package com.martinrist.hibernate.chapter4;

import com.martinrist.hibernate.shared.JPATest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class IdGenerationTest extends JPATest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("HelloWorldPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testNewObject_WithDefaultStrategy_IdIsAvailableBeforePersist() throws Exception {
        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

        DefaultGenerationEntity e = new DefaultGenerationEntity();
        assertThat(e.getId(), nullValue());
        em.persist(e);
        assertThat(e.getId(), notNullValue());

        tx.commit();
    }

    @Test
    public void testNewObject_WithIdentiferStrategy_IdIsNotAvailableUntilCommit() throws Exception {
        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

        IdentityGenerationEntity e = new IdentityGenerationEntity();
        assertThat(e.getId(), nullValue());
        em.persist(e);
        assertThat(e.getId(), notNullValue());

        tx.commit();

        assertThat(e.getId(), notNullValue());
    }


}
