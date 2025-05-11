package org.example.dto;

import java.time.LocalDate;

public class ReviewRequest {
    public String comment;
    public int rating;
    public LocalDate date;
    public Long guestId;
    public Long accommodationId;
}
