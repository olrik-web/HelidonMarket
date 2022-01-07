package dk.eaaa.repository;

import dk.eaaa.domain.*;
import dk.eaaa.repository.entity.AdPO;
import dk.eaaa.repository.entity.UserPO;
import dk.eaaa.repository.entitymanager.AdEntityManager;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This will temporarily be application scoped in order to simulate some DB data
 * Notice that this will not be thread safe in anyway
 */
//@RequestScoped
@ApplicationScoped
public class AdRepository {

    private EntityManager entityManager;
    private Mapper mapper;

    @Inject
    public AdRepository(AdEntityManager adEntityManager, Mapper mapper) {
        this.entityManager = adEntityManager.getEntityManager();
        this.mapper = mapper;
    }

    public List<AdContent> getAds() {
        return entityManager.createNamedQuery(AdPO.FIND_ALL, AdPO.class).getResultList().stream()
                .map(AdPO::toAdContent)
                .collect(Collectors.toList());
    }

    public Ad getAd(Id id) {
        return entityManager.find(AdPO.class, id.getId()).toAd();
    }

    public void createAd(AdContent adContent, Id userId) {
        UserPO userPO = entityManager.find(UserPO.class, userId.getId());

        AdPO qpo = new AdPO(
                adContent.getCategory(),
                adContent.getType(),
                adContent.getHeadline(),
                adContent.getText(),
                adContent.getPrice(),
                adContent.getCreation_date(),
                userPO
        );
        entityManager.persist(qpo);
    }

    public void createUser(UserContent user) {
        UserPO user1 = new UserPO(
                user.getFirst_name(),
                user.getLast_name(),
                user.getCompany(),
                user.getPhone_number(),
                user.getPhone_code(),
                user.getEmail(),
                LocalDate.now(),
                user.getType(),
                user.getCity(),
                user.getZipcode());
        entityManager.persist(user1);
    }

    public List<UserContent> getUsers() {
        return entityManager.createNamedQuery(UserPO.FIND_ALL, UserPO.class).getResultList().stream()
                .map(UserPO::toUserContent)
                .collect(Collectors.toList());
    }

    public User getUser(Id id) {
        return entityManager.find(UserPO.class, id.getId()).toUser();
    }

    public List<Category> getCategories() {
        return Arrays.stream(Category.values()).collect(Collectors.toList());
    }
}
