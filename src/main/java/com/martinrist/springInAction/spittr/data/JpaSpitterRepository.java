package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spitter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of the SpitterRepository interface that is backed by a
 * persistent database store.  Access to the database store is via
 * Spring's Jpa integration.
 */
@Repository
@Transactional("jpaTransactionManager")
@Primary
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext(name = "spittr")
    private EntityManager em;

    @Override
    public Spitter save(Spitter spitter) {

        em.persist(spitter);
        return spitter;
    }

    @Override
    public Spitter findByUserName(String username) {

        return (Spitter) em.createQuery("select s from Spitter s where s.username=:username")
                .setParameter("username", username).getSingleResult();

    }
}
