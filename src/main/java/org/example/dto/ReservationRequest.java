package org.example.dto;

import java.time.LocalDate;

public class ReservationRequest {
    public LocalDate startDate;
    public LocalDate endDate;
    public Long guestId;
    public Long accommodationId;
}
