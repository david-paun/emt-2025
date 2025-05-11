package org.example.service;

import java.util.Optional;

import org.example.model.Availability;

import java.util.List;

public interface AvailabilityService {
    Availability add(Availability availability);
    List<Availability> getByAccommodationId(Long accommodationId);
    List<Availability> getAll();
Optional<Availability> getById(Long id);
Availability update(Availability availability);
void delete(Long id);

}
