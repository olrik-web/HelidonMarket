package dk.eaaa.domain;

import java.time.LocalDate;

public class AdContent {
    private final Id id;
    private final Category category;
    private final String type;
    private final String headline;
    private final String text;
    private final int price;
    private final LocalDate creation_date;

    public AdContent(Id id, Category category, String type, String headline, String text, int price, LocalDate creation_date) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation_date = creation_date;
    }

    public Id getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

}
