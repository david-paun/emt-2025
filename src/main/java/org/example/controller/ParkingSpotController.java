package org.example.controller;

import org.example.model.ParkingSpot;
import org.example.repository.ParkingSpotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking-spots")
public class ParkingSpotController {

    private final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotController(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @GetMapping
    public List<ParkingSpot> all() {
        return parkingSpotRepository.findAll();
    }

    @PostMapping
    public ParkingSpot create(@RequestBody ParkingSpot parkingSpot) {
        return parkingSpotRepository.save(parkingSpot);
    }
}
