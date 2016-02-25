package com.martinrist.hibernate.chapter4;

import com.martinrist.hibernate.shared.JPATest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class IdGenerationTest extends JPATest {

    private EntityManager em;

    @BeforeClass
    public static void configure() throws Exception {
        configurePersistenceUnit("HelloWorldPU");
    }


    @Before
    public void setUp() {
        em = JPA.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
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
