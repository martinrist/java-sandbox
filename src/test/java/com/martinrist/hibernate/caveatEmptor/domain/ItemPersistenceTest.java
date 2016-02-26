package com.martinrist.hibernate.caveatEmptor.domain;

import com.martinrist.hibernate.shared.JPATest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ItemPersistenceTest extends JPATest {

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
    public void testPersistBasicItem() throws Exception {

        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

        Item i = new Item();
        i.setName("Item Name");
        i.setInitialPrice(BigDecimal.ZERO);
        em.persist(i);
        assertThat(i.getId(), notNullValue());

        tx.commit();
    }


    @Test
    public void testPersistItem_BuyNowPriceConversion() throws Exception {

        UserTransaction tx = TM.getUserTransaction();
        tx.begin();

        Item i = new Item();
        i.setName("Item Name");
        i.setInitialPrice(BigDecimal.ZERO);
        i.setBuyNowPrice(MonetaryAmount.fromString("1.50 GBP"));
        em.persist(i);
        tx.commit();

        Item retrievedItem = em.createQuery("select i from Item i where id = :id", Item.class)
                .setParameter("id", i.getId()).getSingleResult();

        assertThat(retrievedItem.getBuyNowPrice(), is(MonetaryAmount.fromString("1.50 GBP")));
    }



}