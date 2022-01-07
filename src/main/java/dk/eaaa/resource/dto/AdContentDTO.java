package dk.eaaa.resource.dto;

import java.time.LocalDate;

public class AdContentDTO {
    private final String id;
    private final String category;
    private final String type;
    private final String headline;
    private final String text;
    private final Integer price;
    private final LocalDate creation_date;

    public AdContentDTO(String id, String category, String type, String headline, String text, Integer price, LocalDate creation_date) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation_date = creation_date;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
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

    public Integer getPrice() {
        return price;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }
}
