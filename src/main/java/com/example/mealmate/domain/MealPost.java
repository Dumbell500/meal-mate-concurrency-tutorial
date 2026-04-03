package com.example.mealmate.domain;

import jakarta.persistence.*;

@Entity
public class MealPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int maxParticipants;
    private int currentParticipants;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Version
    private Long version;

    public MealPost() {
    }

    public Long getId() {
        return id;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(int currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

    public void increaseParticipants() {
        this.currentParticipants++;
    }

    public void changeToFull() {
        this.status = Status.FULL;
    }
}
