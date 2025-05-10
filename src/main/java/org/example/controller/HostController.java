package org.example.controller;

import org.example.model.Country;
import org.example.model.Host;
import org.example.repository.CountryRepository;
import org.example.repository.HostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostController {

    private final HostRepository hostRepo;
    private final CountryRepository countryRepo;

    public HostController(HostRepository hostRepo, CountryRepository countryRepo) {
        this.hostRepo = hostRepo;
        this.countryRepo = countryRepo;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestParam String name,
                                    @RequestParam String surname,
                                    @RequestParam Long countryId) {
        Country country = countryRepo.findById(countryId).orElse(null);
        if (country == null) return ResponseEntity.badRequest().body("Invalid countryId");

        Host host = new Host();
        host.setName(name);
        host.setSurname(surname);
        host.setCountry(country);
        return ResponseEntity.ok(hostRepo.save(host));
    }

    @GetMapping
    public List<Host> getAll() {
        return hostRepo.findAll();
    }
}
