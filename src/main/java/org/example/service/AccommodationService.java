package org.example.service;

import org.example.dto.AccommodationRequest;
import org.example.model.Accommodation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    ResponseEntity<Accommodation> addAccommodation(AccommodationRequest request);
    ResponseEntity<Accommodation> updateAccommodation(Long id, AccommodationRequest request);
    boolean deleteAccommodation(Long id);
    Optional<Accommodation> markAsRented(Long id);
    List<Accommodation> getAll();
    Optional<Accommodation> getById(Long id);
}
