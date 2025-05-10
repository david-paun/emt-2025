package org.example.service;

import org.example.dto.AccommodationRequest;
import org.example.model.Accommodation;
import org.example.model.Category;
import org.example.model.Host;
import org.example.repository.AccommodationRepository;
import org.example.repository.HostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository repository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository repository, HostRepository hostRepository) {
        this.repository = repository;
        this.hostRepository = hostRepository;
    }

    @Override
    public ResponseEntity<Accommodation> addAccommodation(AccommodationRequest request) {
        Optional<Host> hostOpt = hostRepository.findById(request.hostId);
        if (hostOpt.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        Accommodation acc = new Accommodation();
        acc.setName(request.name);
        acc.setCategory(Category.valueOf(request.category));
        acc.setHost(hostOpt.get());
        acc.setNumRooms(request.numRooms);
        acc.setRented(request.rented);

        return ResponseEntity.ok(repository.save(acc));
    }

    @Override
    public ResponseEntity<Accommodation> updateAccommodation(Long id, AccommodationRequest request) {
        Optional<Accommodation> accOpt = repository.findById(id);
        Optional<Host> hostOpt = hostRepository.findById(request.hostId);

        if (accOpt.isEmpty() || hostOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Accommodation acc = accOpt.get();
        acc.setName(request.name);
        acc.setCategory(Category.valueOf(request.category));
        acc.setHost(hostOpt.get());
        acc.setNumRooms(request.numRooms);
        acc.setRented(request.rented);

        return ResponseEntity.ok(repository.save(acc));
    }

    @Override
    public boolean deleteAccommodation(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Accommodation> markAsRented(Long id) {
        return repository.findById(id).map(acc -> {
            acc.setRented(true);
            return repository.save(acc);
        });
    }

    @Override
    public List<Accommodation> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Accommodation> getById(Long id) {
        return repository.findById(id);
    }
}
