package ru.learnup.operasales.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PremiereDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String ageCategory;

    @JsonProperty
    private int numberOfSeats;

    @JsonProperty
    private int numberOfSeatsSold;

    protected PremiereDto() {
    }

    public PremiereDto(Long id, String name, String description, String ageCategory, int numberOfSeats) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ageCategory = ageCategory;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfSeatsSold() {
        return numberOfSeatsSold;
    }

}