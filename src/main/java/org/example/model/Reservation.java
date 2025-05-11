package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Accommodation accommodation;

    public Reservation() {}

    public Reservation(LocalDate startDate, LocalDate endDate, Guest guest, Accommodation accommodation) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.accommodation = accommodation;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

    public Accommodation getAccommodation() { return accommodation; }
    public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }
}
