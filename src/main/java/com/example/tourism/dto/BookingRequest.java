package com.example.tourism.dto;

public record BookingRequest(
    Long tour_id,
    String date
) {
}
