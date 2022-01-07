package dk.eaaa.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UserDTO {
    private final String id;
    private final String first_name;
    private final String last_name;
    private final String phone_number;
    private final String phone_code;
    private final String email;
    private final LocalDate creation_date;
    private final String city;
    private final String company;
    private final String type;
    private final String zipcode;

    public UserDTO(String id,
                   String first_name,
                   String last_name,
                   String phone_number,
                   String phone_code,
                   String email,
                   LocalDate creation_date,
                   String city, @JsonProperty("company") String company, @JsonProperty("type") String type, @JsonProperty("zipcode") String zipcode) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.phone_code = phone_code;
        this.email = email;
        this.creation_date = creation_date;
        this.city = city;
        this.company = company;
        this.type = type;
        this.zipcode = zipcode;
    }


    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPhone_code() {
        return phone_code;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public String getCity() {
        return city;
    }

    public String getCompany() {
        return company;
    }

    public String getType() {
        return type;
    }

    public String getZipcode() {
        return zipcode;
    }
}
