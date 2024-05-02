package com.example.tourism.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String miniTitle;
    private int price;
    @ElementCollection
    private List<String> priceInclude;
    private String bring;
    @ElementCollection
    private List<String> bringCharacteristics;
    private String fullDescription;
    private String day;
    private Category category;
    private String image;
    private String image2;
    private String image3;
    private String image4;
}
