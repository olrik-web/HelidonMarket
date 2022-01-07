package dk.eaaa.repository.entity;

import dk.eaaa.domain.Ad;
import dk.eaaa.domain.AdContent;
import dk.eaaa.domain.Category;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Ad")
@NamedQueries({
        @NamedQuery(name = "AdPO.findAll", query = "SELECT u FROM AdPO u")})
public class AdPO {
    public static final String FIND_ALL = "AdPO.findAll";

    @Id
    @GeneratedValue()
    @Column(name="Id", columnDefinition = "VARCHAR(40)", nullable = false, updatable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name="CATEGORY", columnDefinition = "VARCHAR(40)", nullable = false)
    private Category category;

    @Column(name="TYPE", columnDefinition = "VARCHAR(40)", nullable = false)
    private String type;

    @Column(name="HEADLINE", columnDefinition = "VARCHAR(40)", nullable = false)
    private String headline;

    @Column(name="TEXT", columnDefinition = "VARCHAR(1000)", nullable = false)
    private String text;

    @Column(name="PRICE", nullable = false)
    private int price;

    @Column(name="CREATION_DATE", columnDefinition = "DATE", nullable = false)
    private LocalDate creation_date;

    @ManyToOne
    @JoinColumn(name = "USER_FK", referencedColumnName = "ID")
    private UserPO userPO;


    public AdPO(Category category, String type, String headline, String text, int price, LocalDate creation_date, UserPO userPO) {
        this.category = category;
        this.type = type;
        this.headline = headline;
        this.text = text;
        this.price = price;
        this.creation_date = creation_date;
        this.userPO = userPO;
    }

    public AdPO() {
    }

    public UUID getId() {
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

    public UserPO getUserPO() {
        return userPO;
    }

    public AdContent toAdContent() {
        return new AdContent(new dk.eaaa.domain.Id(id), category, type, headline, text, price, creation_date);
    }

    public Ad toAd() {
        return new Ad(toAdContent(), userPO.toUser());
    }


}