package com.martinrist.springInAction.spittr.data;

import com.martinrist.springInAction.spittr.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Implementation of the SpitterRepository interface that is backed by a
 * persistent database store.  Access to the database store is via
 * Spring's Hibernate integration.
 */
@Repository
@Transactional("hibernateTransactionManager")
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Spitter save(Spitter spitter) {

        Serializable id = currentSession().save(spitter);

        return new Spitter((Long) id,
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getUsername(),
                spitter.getPassword());

    }

    @Override
    public Spitter findByUserName(String username) {

        List userList = currentSession().createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list();

        if (userList == null || userList.size() == 0) {
            return null;
        }

        return (Spitter) userList.get(0);
    }
}
