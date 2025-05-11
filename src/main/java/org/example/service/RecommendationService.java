// src/main/java/org/example/service/RecommendationService.java
package org.example.service;

import org.example.dto.RecommendationDto;

import java.util.List;

public interface RecommendationService {
    List<RecommendationDto> recommendTopRated();
}
