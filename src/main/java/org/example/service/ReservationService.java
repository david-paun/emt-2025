package org.example.service;

import org.example.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation create(Reservation reservation);
    Optional<Reservation> getById(Long id);
    List<Reservation> getAll();
}
