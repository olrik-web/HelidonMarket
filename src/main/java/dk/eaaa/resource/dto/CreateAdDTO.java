package dk.eaaa.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAdDTO {
    private final String category;
    private final String type;
    private final String headline;
    private final String text;
    private final Integer price;

    @JsonCreator
    public CreateAdDTO(@JsonProperty("category") String category,
                       @JsonProperty("type") String type,
                       @JsonProperty("headline") String headline,
                       @JsonProperty("text") String text,
                       @JsonProperty("price") Integer price) {
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
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
}
