package com.example.tourism.services;

import com.example.tourism.security.AdminMiddleware;
import com.example.tourism.models.Booking;
import com.example.tourism.models.Tour;
import com.example.tourism.models.User;
import com.example.tourism.repositories.BookingRepo;
import com.example.tourism.repositories.TourRepo;
import com.example.tourism.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TourRepo tourRepo;
    @Override
    public Booking book(Long tourId, String date, String token) {
        User user = userRepo.findByToken(token);
        Tour tour = tourRepo.getReferenceById(tourId);

        if (user==null) throw new RuntimeException("invalid token");
        if (tour==null) throw new RuntimeException("tour not found");

        Booking booking = new Booking();
        booking.setTour(tour);
        booking.setUser(user);
        booking.setDate(date);

        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> myBookings(String token) {
        User user = userRepo.findByToken(token);
        if (user==null) throw new RuntimeException("invalid token");
        return bookingRepo.findAllByUser(user);
    }

    @Override
    public List<Booking> dateBookings(String date, String token) {
        User user = userRepo.findByToken(token);
        if (!AdminMiddleware.isAdmin(user.getEmail())) {
            throw new RuntimeException("User is not admin");
        }
        return bookingRepo.findAllByDate(date);
    }

    @Override
    public List<Booking> tourBookings(Long tourId, String token) {
        User user = userRepo.findByToken(token);
        if (!AdminMiddleware.isAdmin(user.getEmail())) {
            throw new RuntimeException("User is not admin");
        }
        Tour tour = tourRepo.getReferenceById(tourId);
        return bookingRepo.findAllByTour(tour);
    }
}
