package org.example.repository;

import org.example.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    List<Accommodation> findByRented(boolean rented);
}
