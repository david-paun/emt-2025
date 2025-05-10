package org.example.controller;

import org.example.model.Country;
import org.example.repository.CountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryRepository repo;

    public CountryController(CountryRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        return repo.save(country);
    }

    @GetMapping
    public List<Country> getAll() {
        return repo.findAll();
    }
}
