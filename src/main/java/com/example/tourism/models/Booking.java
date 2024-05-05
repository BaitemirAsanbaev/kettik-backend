package com.example.tourism.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Tour tour;

    private String date;
    private String phone;
    private Integer people;
    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    public Long getTourId() {
        return tour != null ? tour.getId() : null;
    }
}
