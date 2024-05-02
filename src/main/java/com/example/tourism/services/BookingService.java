package com.example.tourism.services;


import com.example.tourism.models.Booking;
import com.example.tourism.models.Tour;

import java.util.List;

public interface BookingService {
    Booking book(Long tourId, String date, String token);
    List<Booking> myBookings(String token);
    List<Booking> dateBookings(String date, String token);
    List<Booking> tourBookings(Long tourId, String token);
}
