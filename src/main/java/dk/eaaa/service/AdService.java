package dk.eaaa.service;

import dk.eaaa.domain.*;
import dk.eaaa.repository.AdRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class AdService {

    private AdRepository repository;

    //ADS
    @Inject
    public AdService(AdRepository repository) {
        this.repository = repository;
    }

    public List<AdContent> getAds(Category category) {
        return repository.getAds().stream().filter(ad -> ad.getCategory()==category).collect(Collectors.toList());
    }

    public User getUser(Id id) {
        return repository.getUser(id);
    }


    public void createAd(AdContent ad, Id id) {
      repository.createAd(ad, id);
    }

    public Ad getAd(Id id) {
        return repository.getAd(id);
    }

    //USERS
    public void createUser(UserContent user) {
        repository.createUser(user);
    }

    public List<UserContent> getUsers() {
        return repository.getUsers();
    }

    //CATEGORIES
    public List<Category> getCategories() {return repository.getCategories();}

    public Map<Category, Integer> getNumberOfCategories() {
        Map<Category, Integer> map = new HashMap<>();

        getCategories().forEach(
                c -> map.put(c,0)
        );

        for(AdContent ad : repository.getAds()) {
            map.put(ad.getCategory(), map.get(ad.getCategory()) + 1);
        }
        return map;
    }
}
