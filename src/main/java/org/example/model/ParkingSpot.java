package org.example.model;

import jakarta.persistence.*;

@Entity
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private boolean covered;

@ManyToOne(optional = false)
@JoinColumn(name = "accommodation_id", nullable = false)
private Accommodation accommodation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
