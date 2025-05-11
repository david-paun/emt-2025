package org.example.service;

import org.example.model.Review;
import org.example.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review addReview(Review review) {
        return repository.save(review);
    }

    @Override
    public List<Review> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Review> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
