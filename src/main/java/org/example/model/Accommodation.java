package org.example.model;

import jakarta.persistence.*;

@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Host host;

    private Integer numRooms;

    private boolean rented;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Host getHost() {
        return host;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public boolean isRented() {
        return rented;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
