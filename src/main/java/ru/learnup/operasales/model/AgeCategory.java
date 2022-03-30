package ru.learnup.operasales.model;

public enum AgeCategory {

    CATEGORY_6PLUS("Категория 6+"),
    CATEGORY_12PLUS("Категория 12+"),
    CATEGORY_18PLUS("Категория 18+");

    private final String name;

    AgeCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}