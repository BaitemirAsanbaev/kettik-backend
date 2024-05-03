package com.example.tourism.controllers;

import com.example.tourism.dto.TourRequest;
import com.example.tourism.models.Category;
import com.example.tourism.models.Tour;
import com.example.tourism.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
@CrossOrigin("*")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public List<Tour> tours() {
        return tourService.getAllTours();
    }
    @GetMapping("/categories")
    public List<Category> categories() {
        return tourService.getAllCategories();
    }
    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable Long id) {
        return tourService.getTourById(id);
    }
    @PostMapping(path = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object createTour(@ModelAttribute TourRequest request, @RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return tourService.createTour(request, token);
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }
    @DeleteMapping("/delete/{id}")
    public Tour deleteTour(@PathVariable Long id){
        return tourService.deleteTour(id);
    }
}
