package dk.eaaa.domain;

public class Ad {
    private final AdContent adContent;
    private final User user;


    public Ad(AdContent adContent, User user) {
        this.adContent = adContent;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public AdContent getAdContent() {
        return adContent;
    }
}
