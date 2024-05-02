package com.example.tourism.controllers;

import com.example.tourism.dto.BookingRequest;
import com.example.tourism.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book")
    public Object book(@RequestBody BookingRequest request, @RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return bookingService.book(request.tour_id(), request.date(), token);
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @GetMapping("/my")
    public Object myBookings(@RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return bookingService.myBookings(token);
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }
    @GetMapping("/date")
    public Object dateBookings(@RequestHeader BookingRequest request,@RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return bookingService.dateBookings( request.date(),token);
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }
    @GetMapping("/tour")
    public Object tourBookings(@RequestHeader BookingRequest request,@RequestHeader("Authorization") String header){
        String token = header.split(" ")[1];
        try{
            return bookingService.tourBookings( request.tour_id(),token);
        }
        catch (RuntimeException e){
            return e.getMessage();
        }
    }
}
