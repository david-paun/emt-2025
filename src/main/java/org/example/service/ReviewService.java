package org.example.service;

import org.example.model.Review;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review addReview(Review review);
    List<Review> getAll();
    Optional<Review> getById(Long id);
    boolean deleteById(Long id);
}
