package com.example.tourism.dto;

import com.example.tourism.models.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record TourRequest(
        String title,
        String miniTitle,
        int price,
        List<String>priceInclude,
        String bring,
        List<String>bringCharacteristics,
        String fullDescription,
        String day,
        Category category,
        String image,
        String image2,
        String image3,
        String image4
) {
}
