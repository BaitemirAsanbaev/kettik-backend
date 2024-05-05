package com.example.tourism.services;


import com.example.tourism.models.Booking;
import com.example.tourism.models.Tour;
import org.apache.coyote.BadRequestException;
import org.apache.http.auth.AuthenticationException;
import org.springframework.expression.AccessException;

import java.util.List;

public interface BookingService {
    Booking book(Long tourId, String date, String phone, Integer people, String token) throws AuthenticationException, BadRequestException;
    List<Booking> allBookings(String token) throws AuthenticationException, AccessException;
    List<Booking> myBookings(String token) throws AuthenticationException;
    List<Booking> dateBookings(String date, String token) throws AuthenticationException, AccessException;
    List<Booking> tourBookings(Long tourId, String token) throws AuthenticationException, AccessException;
}
