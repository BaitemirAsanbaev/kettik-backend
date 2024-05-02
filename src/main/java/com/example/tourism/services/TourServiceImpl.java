package com.example.tourism.services;

import com.example.tourism.dto.TourRequest;
import com.example.tourism.security.AdminMiddleware;
import com.example.tourism.models.Tour;
import com.example.tourism.models.User;
import com.example.tourism.repositories.TourRepo;
import com.example.tourism.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourRepo tourRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CloudinaryService cloudinaryService;

    @Override
    public List<Tour> getAllTours() {
        return tourRepo.findAll();
    }

    @Override
    public Tour getTourById(Long id) {
        return tourRepo.getReferenceById(id);
    }

    @Override
    public Tour createTour(TourRequest request, String token) {
        User user = userRepo.findByToken(token);
        if (user==null){
            throw new RuntimeException("User does not exist");
        }
        if (!AdminMiddleware.isAdmin(user.getEmail())) {
            throw new RuntimeException("User is not admin");
        }

        Tour tour = new Tour();
        tour.setTitle(request.title());
        tour.setMiniTitle(request.miniTitle());
        tour.setDay(request.day());
        tour.setPrice(request.price());
        tour.setPriceInclude(request.priceInclude());
        tour.setBring(request.bring());
        tour.setCategory(request.category());
        tour.setFullDescription(request.fullDescription());
        tour.setBringCharacteristics(request.bringCharacteristics());
        tour.setImage(cloudinaryService.upload(request.image()));
        tour.setImage2(cloudinaryService.upload(request.image()));
        tour.setImage3(cloudinaryService.upload(request.image()));
        tour.setImage4(cloudinaryService.upload(request.image()));
        return tourRepo.save(tour);
    }

    @Override
    public Tour deleteTour(Long id) {
        tourRepo.deleteById(id);
        return tourRepo.getReferenceById(id);
    }
}
