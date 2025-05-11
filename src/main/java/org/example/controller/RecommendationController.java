// src/main/java/org/example/controller/RecommendationController.java
package org.example.controller;

import org.example.dto.RecommendationDto;
import org.example.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping
    public List<RecommendationDto> topRecommendations() {
        return service.recommendTopRated();
    }
}
