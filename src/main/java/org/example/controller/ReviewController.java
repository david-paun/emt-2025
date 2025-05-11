package org.example.controller;

import org.example.dto.ReviewRequest;
import org.example.model.Review;
import org.example.repository.AccommodationRepository;
import org.example.repository.GuestRepository;
import org.example.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final GuestRepository guestRepository;
    private final AccommodationRepository accommodationRepository;

    public ReviewController(ReviewService reviewService, GuestRepository guestRepository, AccommodationRepository accommodationRepository) {
        this.reviewService = reviewService;
        this.guestRepository = guestRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostMapping
    public Review create(@RequestBody ReviewRequest req) {
        Review review = new Review();
        review.setComment(req.comment);
        review.setRating(req.rating);
        review.setDate(req.date);
        review.setGuest(guestRepository.findById(req.guestId).orElseThrow());
        review.setAccommodation(accommodationRepository.findById(req.accommodationId).orElseThrow());
        return reviewService.addReview(review);
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}
