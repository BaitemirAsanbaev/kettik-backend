package com.example.tourism.controllers;

import com.example.tourism.dto.BookingRequest;
import com.example.tourism.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<?> book(@RequestBody BookingRequest request, @RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        try {
            return ResponseEntity.ok(bookingService.book(request.tour_id(), request.date(), token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/my")
    public ResponseEntity<?> myBookings(@RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        try {
            return ResponseEntity.ok(bookingService.myBookings(token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/date")
    public ResponseEntity<?> dateBookings(@RequestBody BookingRequest request, @RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        try {
            return ResponseEntity.ok(bookingService.dateBookings(request.date(), token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/tour")
    public ResponseEntity<?> tourBookings(@RequestBody BookingRequest request, @RequestHeader("Authorization") String header) {
        String token = header.split(" ")[1];
        try {
            return ResponseEntity.ok(bookingService.tourBookings(request.tour_id(), token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
