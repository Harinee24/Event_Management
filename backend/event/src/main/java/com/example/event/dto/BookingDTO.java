package com.example.event.dto;

public class BookingDTO {
    private Long id;
    private Long eventId;
    private Long userId;
    private int numberOfSeats;
    private String status; // e.g., CONFIRMED, CANCELLED, PENDING
    private String eventName;   // add this
    private String username;    // add this

    public BookingDTO() {}

    public BookingDTO(Long id, Long eventId, Long userId, int numberOfSeats, String status, String eventName, String username) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.numberOfSeats = numberOfSeats;
        this.status = status;
        this.eventName = eventName;
        this.username = username;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public int getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

}
