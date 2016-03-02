package com.martinrist.hibernate.chapter10;

import com.martinrist.hibernate.caveatEmptor.domain.Item;
import com.martinrist.hibernate.shared.JPATest;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.transaction.UserTransaction;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PersistenceLifecycleTest extends JPATest {

    private EntityManager em;
    private UserTransaction tx;
    private Item item = Item.newInstance("Item 1");

    @BeforeClass
    public static void configure() throws Exception {
        configurePersistenceUnit("CaveatEmptorPU");
    }

    @Before
    public void setUp() {
        em = JPA.createEntityManager();
        tx = TM.getUserTransaction();
    }

    @After
    public void tearDown() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    @Test
    public void testPersist_IdIsNullBeforePersist() throws Exception {
        assertThat(item.getId(), nullValue());
    }

    @Test
    public void testPersist_IdIsNotNullAfterPersist() throws Exception {
        em.persist(item);
        assertThat(item.getId(), notNullValue());
    }

    @Test
    public void testPersist_EntityManagerContainsInstanceAfterPersist() throws Exception {
        assertThat(em.contains(item), is(false));
        em.persist(item);
        assertThat(em.contains(item), is(true));
    }

    @Test
    public void testRetrieveWithFind_RetrievesNonNullInstance() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        tx.begin();
        Item retrieved = em.find(Item.class, id);
        assertThat(retrieved, notNullValue());
        tx.commit();
    }


    @Test
    public void testRetrieveWithFind_RepeatableReadReturnsSameInstance() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        Item itemA = em.find(Item.class, id);
        Item itemB = em.find(Item.class, id);

        assertThat(itemA, sameInstance(itemB));
    }

    @Test
    public void testRetrieveAndModify() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        tx.begin();
        Item retrieved = em.find(Item.class, id);
        retrieved.setName("Item 1 - Edited");
        tx.commit();
        em.close();

        em = JPA.createEntityManager();
        Item modified = em.find(Item.class, id);
        assertThat(modified.getName(), is("Item 1 - Edited"));
        em.close();
    }

    @Test
    public void testGetReference_AlreadyInContextReturnsPersistentInstance() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        Item retrieved = em.find(Item.class, id);
        Item reference = em.getReference(Item.class, id);
        assertThat(reference, sameInstance(retrieved));
    }

    @Test
    public void testGetReference_NotInContextReturnsProxy() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        assertThat(em.contains(item), is(false));

        Item reference = em.getReference(Item.class, id);
        assertThat(reference, instanceOf(Item.class));
        assertThat(reference, not(sameInstance(item)));

    }

    @Test
    public void testGetReference_ProxyIsNotLoaded() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        PersistenceUnitUtil util = em.getEntityManagerFactory().getPersistenceUnitUtil();

        Item reference = em.getReference(Item.class, id);

        assertThat(util.isLoaded(reference), is(false));
    }

    @Test
    public void testGetReference_AccessingPropertyInitialisesProxy() throws Exception {
        Long id = addItem(item);
        em.close();

        em = JPA.createEntityManager();
        Item reference = em.getReference(Item.class, id);
        String name = reference.getName();

        assertThat(name, is(item.getName()));
        assertThat(reference.getId(), is(id));
    }

    @Test
    public void testRemove_EntityNoLongerFound() throws Exception {
        Long id = addItem(item);

        tx.begin();
        em.remove(item);
        tx.commit();

        em.close();

        em = JPA.createEntityManager();
        Item item = em.find(Item.class, id);
        assertThat(item, nullValue());

    }

    @Test
    public void testRemove_EntityManagerDoesNotContainInstance() throws Exception {
        addItem(item);
        em.remove(item);
        assertThat(em.contains(item), is(false));
    }

    @Test
    public void testRemove_EntityIdIsNotRolledBackBeforeCommit() throws Exception {
        addItem(item);
        em.remove(item);
        assertThat(item.getId(), notNullValue());
    }

    @Test
    public void testRemove_EntityIdIsNotRolledBackAfterCommit() throws Exception {
        addItem(item);
        tx.begin();
        em.remove(item);
        tx.commit();

        assertThat(item.getId(), notNullValue());
    }

    @Test
    public void testRemove_InstanceCanBeRepersisted() throws Exception {
        Long id = addItem(item);
        tx.begin();
        em.remove(item);
        em.persist(item);
        tx.commit();

        em.close();
        em = JPA.createEntityManager();

        Item retrieved = em.find(Item.class, id);
        assertThat(retrieved.getId(), is(id));

    }

    private Long addItem(Item i) throws Exception {
        tx.begin();
        em.persist(item);
        tx.commit();

        return item.getId();
    }
}
