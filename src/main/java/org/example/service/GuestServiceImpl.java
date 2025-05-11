package org.example.service;

import org.example.dto.GuestRequest;
import org.example.model.Guest;
import org.example.model.Host;
import org.example.repository.GuestRepository;
import org.example.repository.HostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepo;
    private final HostRepository hostRepo;

    public GuestServiceImpl(GuestRepository guestRepo, HostRepository hostRepo) {
        this.guestRepo = guestRepo;
        this.hostRepo = hostRepo;
    }

    @Override
    public Guest create(GuestRequest request) {
        Host host = hostRepo.findById(request.getHostId())
                .orElseThrow(() -> new IllegalArgumentException("Host not found with id: " + request.getHostId()));

        Guest guest = new Guest();
        guest.setName(request.getName());
        guest.setEmail(request.getEmail());
        guest.setHost(host);

        return guestRepo.save(guest);
    }

    @Override
    public List<Guest> getAll() {
        return guestRepo.findAll();
    }

    @Override
    public Optional<Guest> getById(Long id) {
        return guestRepo.findById(id);
    }
}
