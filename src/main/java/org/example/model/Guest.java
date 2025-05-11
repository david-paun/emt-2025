package org.example.model;

import jakarta.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public Host getHost() { return host; }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    public void setHost(Host host) { this.host = host; }
}
