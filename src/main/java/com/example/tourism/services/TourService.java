package com.example.tourism.services;

import com.example.tourism.dto.TourRequest;
import com.example.tourism.models.Category;
import com.example.tourism.models.Tour;

import java.util.List;

public interface TourService {
    List<Tour> getAllTours();
    List<Category> getAllCategories();
    Tour getTourById(Long id);
    Tour createTour(TourRequest request, String token);
    Tour deleteTour(Long id);
}
