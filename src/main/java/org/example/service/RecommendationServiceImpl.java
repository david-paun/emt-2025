// src/main/java/org/example/service/RecommendationServiceImpl.java
package org.example.service;

import org.example.dto.RecommendationDto;
import org.example.model.Accommodation;
import org.example.repository.AccommodationRepository;
import org.example.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final AccommodationRepository accommodationRepo;
    private final ReviewRepository reviewRepo;

    public RecommendationServiceImpl(AccommodationRepository accommodationRepo, ReviewRepository reviewRepo) {
        this.accommodationRepo = accommodationRepo;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<RecommendationDto> recommendTopRated() {
        return accommodationRepo.findAll().stream()
                .map(acc -> {
                    double avgRating = reviewRepo.findByAccommodationId(acc.getId()).stream()
                        .mapToInt(r -> r.getRating()).average().orElse(0.0);
                    return new RecommendationDto(acc.getId(), acc.getName(), avgRating);
                })
                .sorted((a, b) -> Double.compare(b.getAvgRating(), a.getAvgRating()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
