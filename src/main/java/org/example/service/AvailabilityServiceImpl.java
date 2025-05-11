package org.example.service;

import org.example.model.Availability;
import org.example.repository.AvailabilityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepo;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepo) {
        this.availabilityRepo = availabilityRepo;
    }

    @Override
    public Availability add(Availability availability) {
        validateDateRange(availability);
        checkConflicts(availability);
        return availabilityRepo.save(availability);
    }

    @Override
    public List<Availability> getByAccommodationId(Long accommodationId) {
        return availabilityRepo.findByAccommodationId(accommodationId);
    }

    @Override
    public List<Availability> getAll() {
        return availabilityRepo.findAll();
    }

    @Override
    public Optional<Availability> getById(Long id) {
        return availabilityRepo.findById(id);
    }

    @Override
    public Availability update(Availability availability) {
        validateDateRange(availability);
        checkConflicts(availability);
        return availabilityRepo.save(availability);
    }

    @Override
    public void delete(Long id) {
        availabilityRepo.deleteById(id);
    }

    private void validateDateRange(Availability availability) {
        if (availability.getStartDate() == null || availability.getEndDate() == null) {
            throw new IllegalArgumentException("Start date and end date must not be null.");
        }
        if (!availability.getStartDate().isBefore(availability.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
    }

    private void checkConflicts(Availability availability) {
        List<Availability> existing = availabilityRepo.findByAccommodationId(availability.getAccommodation().getId());

        for (Availability a : existing) {
            // Skip the same record in case of updates
            if (availability.getId() != null && availability.getId().equals(a.getId())) continue;

            boolean overlaps =
                !(availability.getEndDate().isBefore(a.getStartDate()) || availability.getStartDate().isAfter(a.getEndDate()));

            if (overlaps) {
                throw new IllegalArgumentException("Date range overlaps with existing availability.");
            }
        }
    }
}
