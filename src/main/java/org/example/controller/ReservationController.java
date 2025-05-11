package org.example.controller;

import org.example.dto.ReservationRequest;
import org.example.model.Accommodation;
import org.example.model.Guest;
import org.example.model.Reservation;
import org.example.repository.AccommodationRepository;
import org.example.repository.GuestRepository;
import org.example.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final GuestRepository guestRepo;
    private final AccommodationRepository accommodationRepo;

    public ReservationController(ReservationService reservationService, GuestRepository guestRepo, AccommodationRepository accommodationRepo) {
        this.reservationService = reservationService;
        this.guestRepo = guestRepo;
        this.accommodationRepo = accommodationRepo;
    }

    @PostMapping
    public Reservation create(@RequestBody ReservationRequest request) {
        Guest guest = guestRepo.findById(request.guestId).orElseThrow();
        Accommodation accommodation = accommodationRepo.findById(request.accommodationId).orElseThrow();
        Reservation reservation = new Reservation(request.startDate, request.endDate, guest, accommodation);
        return reservationService.create(reservation);
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation get(@PathVariable Long id) {
        return reservationService.getById(id).orElseThrow();
    }
}
