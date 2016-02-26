package com.martinrist.hibernate.caveatEmptor.domain;

import com.martinrist.hibernate.shared.JPATest;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.junit.Assert.assertThat;

public class UserPersistenceTest extends JPATest {

    private EntityManager em;

    @BeforeClass
    public static void configure() throws Exception {
        configurePersistenceUnit("CaveatEmptorPU");
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
    public void testPersistUser_GermanZipcode() throws Exception {

        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

        User u = new User();

        u.setHomeAddress(new Address("Street", new GermanZipcode("12345"), "Hamburg"));
        em.persist(u);

        tx.commit();

        User retrievedUser = em.createQuery("select u from User u where id = :id", User.class)
                .setParameter("id", u.getId()).getSingleResult();

        assertThat(retrievedUser.getHomeAddress().getZipcode(), Matchers.instanceOf(GermanZipcode.class));
    }


}