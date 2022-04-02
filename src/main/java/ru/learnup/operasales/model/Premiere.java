package ru.learnup.operasales.model;

import javax.persistence.*;

@Entity
@Table(name = "PLAYBILL")
public class Premiere {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PLAYBILL", sequenceName = "SEQ_PLAYBILL")
    private Long id;

    @Column(name = "NAME", length=255)
    private String name;

    @Column(name = "DESCRIPTION", length=2000)
    private String description;

    @Column(name = "AGE_CATEGORY", length=30)
    private AgeCategory ageCategory;

    @Column(name = "SEATS")
    private int numberOfSeats;

    @Column(name = "SEATS_SOLD")
    private int numberOfSeatsSold;

    protected Premiere() {
    }

    public Premiere(String name, String description, AgeCategory ageCategory, int numberOfSeats) {
        this.name = name;
        this.description = description;
        this.ageCategory = ageCategory;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
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