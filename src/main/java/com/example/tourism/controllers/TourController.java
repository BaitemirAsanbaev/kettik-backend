package com.example.tourism.controllers;

import com.example.tourism.dto.TourRequest;
import com.example.tourism.models.Category;
import com.example.tourism.models.Tour;
import com.example.tourism.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> createTour(@ModelAttribute TourRequest request, @RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        try {
            return ResponseEntity.ok(tourService.createTour(request, token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id, @RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        try{

            return ResponseEntity.ok(tourService.deleteTour(id, token));
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
