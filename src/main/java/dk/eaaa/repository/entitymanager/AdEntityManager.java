package dk.eaaa.repository.entitymanager;

import javax.persistence.EntityManager;

public class AdEntityManager {

    private final EntityManager entityManager;

    public AdEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
