package dk.eaaa.repository.entity;

import dk.eaaa.domain.User;
import dk.eaaa.domain.UserContent;
import org.hibernate.annotations.Type;

import javax.ejb.Local;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name="AD_USER")
@NamedQueries({
        @NamedQuery(name = "UserPO.findAll", query = "SELECT u FROM UserPO u")})
public class UserPO {
    public static final String FIND_ALL = "UserPO.findAll";

    @Id
    @GeneratedValue()
    @Column(name = "ID", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name="FIRST_NAME", columnDefinition = "VARCHAR(30)", nullable = false)
    private String first_name;

    @Column(name="LAST_NAME", columnDefinition = "VARCHAR(30)", nullable = false)
    private String last_name;

    @Column(name="COMPANY", columnDefinition = "VARCHAR(40)")
    private String company;

    @Column(name="PHONE_NUMBER", columnDefinition = "VARCHAR(20)", nullable = false)
    private String phone_number;

    @Column(name="PHONE_CODE", columnDefinition = "VARCHAR(10)", nullable = false)
    private String phone_code;

    @Column(name="EMAIL", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(name="CREATION_DATE", columnDefinition = "DATE", nullable = false)
    private LocalDate creation_date;

    @Column(name="TYPE", columnDefinition = "VARCHAR(10)", nullable = false)
    private String type;

    @Column(name="CITY", columnDefinition = "VARCHAR(40)", nullable = false)
    private String city;

    @Column(name="ZIPCODE", columnDefinition = "VARCHAR(40)", nullable = false)
    private String zipcode;

    @OneToMany(mappedBy = "userPO")
    private List<AdPO> ads;

    public UserPO(String first_name,
                  String last_name,
                  String company,
                  String phone_number,
                  String phone_code,
                  String email,
                  LocalDate creation_date,
                  String type,
                  String city,
                  String zipcode) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.company = company;
        this.phone_number = phone_number;
        this.phone_code = phone_code;
        this.email = email;
        this.creation_date = creation_date;
        this.type = type;
        this.city = city;
        this.zipcode = zipcode;
        ads = new ArrayList<>();
    }

    public UserPO() {
    }

    public UUID getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCompany() {
        return company;
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

    public String getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public void addAd(AdPO adPO) {
        ads.add(adPO);
    }

    public String getZipcode() {
        return zipcode;
    }


    public User toUser() {
        return new User(toUserContent(), ads.stream().map(AdPO::toAdContent).collect(Collectors.toList()));
    }

    public UserContent toUserContent() {
        return new UserContent(new dk.eaaa.domain.Id(id), first_name, last_name, phone_number, phone_code, email, creation_date, city, company, type, zipcode);
    }
}
