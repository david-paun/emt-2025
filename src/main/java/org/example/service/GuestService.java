package org.example.service;

import org.example.dto.GuestRequest;
import org.example.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    Guest create(GuestRequest guest);
    List<Guest> getAll();
    Optional<Guest> getById(Long id);
}
