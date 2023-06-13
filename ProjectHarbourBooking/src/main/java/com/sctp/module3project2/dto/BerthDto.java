package com.sctp.module3project2.dto;

// DATA TRANSFER OBJECTS.
public class BerthDto {
    private Long id;
    private String name;
    private boolean availability;
    private String location; // Add the location field

    // CONSTRUCTORS.
    public BerthDto() {
    }

    public BerthDto(Long id, String name, boolean availability, String location) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.location = location;
    }

    // GETTERS & SETTERS.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
