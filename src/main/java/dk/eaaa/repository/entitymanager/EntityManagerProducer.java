package dk.eaaa.repository.entitymanager;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class EntityManagerProducer {

    private static final String PERSISTENCE_UNIT = "ad";

    @PersistenceContext(unitName = PERSISTENCE_UNIT)
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public AdEntityManager produce() {
        return new AdEntityManager(entityManager);
    }

}