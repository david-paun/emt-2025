package org.example.repository;

import org.example.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {}
