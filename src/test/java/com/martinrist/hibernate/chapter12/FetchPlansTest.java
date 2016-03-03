package com.martinrist.hibernate.chapter12;

import com.martinrist.hibernate.caveatEmptor.domain.Address;
import com.martinrist.hibernate.caveatEmptor.domain.GermanZipcode;
import com.martinrist.hibernate.caveatEmptor.domain.Item;
import com.martinrist.hibernate.caveatEmptor.domain.User;
import com.martinrist.hibernate.shared.JPATest;
import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FetchPlansTest extends JPATest {

    private EntityManager em;
    private UserTransaction tx;
    private Item item;
    private User user;

    @BeforeClass
    public static void configure() throws Exception {
        configurePersistenceUnit("CaveatEmptorPU");
    }

    @Before
    public void setUp() throws Exception {

        item = Item.newInstance("Item 1");
        user = User.newInstance("User 1");

        Address homeAddress = new Address("Street", new GermanZipcode("12345"), "Hamburg");
        user.setHomeAddress(homeAddress);

        item.setSeller(user);

        tx = TM.getUserTransaction();
        tx.begin();
        em = JPA.createEntityManager();
        em.persist(item);
        em.persist(user);
        tx.commit();
        em.close();
        em = JPA.createEntityManager();

    }

    @After
    public void tearDown() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }


    @Test
    public void testGetReference_WhenReturned_ProxyIsNotInitialised() {
        Item reference = em.getReference(Item.class, item.getId());
        assertThat(Hibernate.isInitialized(reference), is(false));
    }

    @Test
    public void testGetReference_WhenIdAccessed_ProxyIsInitialised() {
        Item reference = em.getReference(Item.class, item.getId());
        // This causes proxy initialisation because @Id is on the field not on the getter
        reference.getId();
        assertThat(Hibernate.isInitialized(reference), is(true));
    }

    @Test
    public void testGetReference_WhenOtherPropertyAccessed_ProxyIsInitialised() {
        Item reference = em.getReference(Item.class, item.getId());
        reference.getName();
        assertThat(Hibernate.isInitialized(reference), is(true));
    }

    @Test
    public void testRetrieveItem_LazyAssociationToSeller_NotInitialised() {
        Item retrieved = em.find(Item.class, item.getId());
        assertThat(Hibernate.isInitialized(retrieved.getSeller()), is(false));
    }

    @Test
    public void testRetrieveItem_LazyAssociationToSeller_InitialisedAfterAccessingProperty() {
        Item retrievedItem = em.find(Item.class, item.getId());
        User seller = retrievedItem.getSeller();
        seller.getFirstname();
        assertThat(Hibernate.isInitialized(seller), is(true));
    }

    @Test(expected = LazyInitializationException.class)
    public void testRetrieveItemSeller_WhenAccessedInDetachedMode_ThrowsLazyInitializationExcpetion() {
        Item retrievedItem = em.find(Item.class, item.getId());
        User seller = retrievedItem.getSeller();
        em.close();

        seller.getFirstname();

    }
}
