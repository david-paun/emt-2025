package org.example.dto;

public class GuestRequest {
    private String name;
    private String email;
    private Long hostId;

    public String getName() { return name; }
    public String getEmail() { return email; }
    public Long getHostId() { return hostId; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setHostId(Long hostId) { this.hostId = hostId; }
}
