package ru.learnup.operasales.model;

public class Premiere {

    private final String name;
    private String description;
    private AgeCategory ageCategory;
    private final int numberOfSeats;
    private int numberOfSeatsSold;

    public Premiere(String name, String description, AgeCategory ageCategory, int numberOfSeats) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfSeatsSold() {
        return numberOfSeatsSold;
    }

    public void setNumberOfSeatsSold(int numberOfSeatsSold) {
        this.numberOfSeatsSold = numberOfSeatsSold;
    }

    @Override
    public String toString() {
        return "Премьера {" +
                "Наименование='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", Возрастная категория='" + ageCategory.getName() + '\'' +
                ", Количество мест=" + numberOfSeats +
                ", Количество проданных мест=" + numberOfSeatsSold + "}";
    }
}