package dk.eaaa.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class User {
    private final UserContent userContent;
    private final List<AdContent> adContentList;

    public User(UserContent userContent, List<AdContent> adContentList) {
        this.userContent = userContent;
        this.adContentList = adContentList;
    }

    public UserContent getUserContent() {
        return userContent;
    }

    public List<AdContent> getAdContentList() {
        return adContentList;
    }
}
