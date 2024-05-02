package com.example.tourism.repositories;

import com.example.tourism.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepo extends JpaRepository<Tour, Long> {

}
