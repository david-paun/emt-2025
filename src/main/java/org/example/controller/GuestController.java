package org.example.controller;

import org.example.dto.GuestRequest;
import org.example.model.Guest;
import org.example.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping
    public Guest create(@RequestBody GuestRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<Guest> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Guest getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
    }
}
