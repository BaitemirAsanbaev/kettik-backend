package com.example.tourism.repositories;

import com.example.tourism.models.Booking;
import com.example.tourism.models.Tour;
import com.example.tourism.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUser(User user);
    List<Booking> findAllByDate(String date);
    List<Booking> findAllByTour(Tour tour);
}
