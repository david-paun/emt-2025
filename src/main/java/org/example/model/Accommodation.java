package org.example.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;
    private int numRooms;
    private boolean rented;
    private double price;

    @ManyToOne
    private Host host;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Availability> availabilities = new ArrayList<>();

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
