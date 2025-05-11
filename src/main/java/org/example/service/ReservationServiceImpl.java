package org.example.service;

import org.example.model.Accommodation;
import org.example.model.Guest;
import org.example.model.Reservation;
import org.example.repository.AccommodationRepository;
import org.example.repository.GuestRepository;
import org.example.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepo;
    private final GuestRepository guestRepo;
    private final AccommodationRepository accommodationRepo;

    public ReservationServiceImpl(ReservationRepository reservationRepo, GuestRepository guestRepo, AccommodationRepository accommodationRepo) {
        this.reservationRepo = reservationRepo;
        this.guestRepo = guestRepo;
        this.accommodationRepo = accommodationRepo;
    }

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Optional<Reservation> getById(Long id) {
        return reservationRepo.findById(id);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepo.findAll();
    }
}
