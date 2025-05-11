package org.example.repository;

import org.example.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByAccommodationId(Long accommodationId);
}
