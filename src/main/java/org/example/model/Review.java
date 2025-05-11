package org.example.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;
    private LocalDate date;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Accommodation accommodation;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

    public Accommodation getAccommodation() { return accommodation; }
    public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }
}
