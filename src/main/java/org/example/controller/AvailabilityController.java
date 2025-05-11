package org.example.controller;

import org.example.dto.AvailabilityRequest;
import org.example.model.Availability;
import org.example.model.Accommodation;
import org.example.repository.AccommodationRepository;
import org.example.service.AvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    private final AvailabilityService service;
    private final AccommodationRepository accommodationRepo;

    public AvailabilityController(AvailabilityService service, AccommodationRepository accommodationRepo) {
        this.service = service;
        this.accommodationRepo = accommodationRepo;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AvailabilityRequest req) {
        try {
            Accommodation accommodation = accommodationRepo.findById(req.accommodationId)
                    .orElseThrow(() -> new RuntimeException("Accommodation not found"));

            Availability a = new Availability();
            a.setStartDate(req.startDate);
            a.setEndDate(req.endDate);
            a.setAccommodation(accommodation);

            return ResponseEntity.ok(service.add(a));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/by-accommodation/{id}")
    public List<Availability> getByAccommodation(@PathVariable Long id) {
        return service.getByAccommodationId(id);
    }

    @GetMapping
    public List<Availability> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AvailabilityRequest req) {
        try {
            Availability existing = service.getById(id)
                    .orElseThrow(() -> new RuntimeException("Availability not found"));

            Accommodation accommodation = accommodationRepo.findById(req.accommodationId)
                    .orElseThrow(() -> new RuntimeException("Accommodation not found"));

            existing.setStartDate(req.startDate);
            existing.setEndDate(req.endDate);
            existing.setAccommodation(accommodation);

            return ResponseEntity.ok(service.update(existing));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
