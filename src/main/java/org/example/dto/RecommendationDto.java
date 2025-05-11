// src/main/java/org/example/dto/RecommendationDto.java
package org.example.dto;

public class RecommendationDto {
    private Long id;
    private String name;
    private double avgRating;

    // Constructors
    public RecommendationDto() {}

    public RecommendationDto(Long id, String name, double avgRating) {
        this.id = id;
        this.name = name;
        this.avgRating = avgRating;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getAvgRating() { return avgRating; }
    public void setAvgRating(double avgRating) { this.avgRating = avgRating; }
}
