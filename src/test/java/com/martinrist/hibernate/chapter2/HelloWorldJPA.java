package com.martinrist.hibernate.chapter2;

import com.martinrist.hibernate.shared.TransactionManagerTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class HelloWorldJPA extends TransactionManagerTest {

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
    public void testAddSingleMessage_ThenRetrieve() throws Exception {
        addMessage("Hello World");
        List<Message> messages = getMessages();

        assertThat(messages, hasSize(1));
        assertThat(messages, containsInAnyOrder(new Message(1L, "Hello World")));
    }


    @Test
    public void testAddMultipleMessages_ThenRetrieve() throws Exception {
        addMessage("Message 1");
        addMessage("Message 2");
        List<Message> messages = getMessages();

        assertThat(messages, hasSize(2));
        assertThat(messages, contains(new Message(1L, "Message 1"),
                new Message(2L, "Message 2")));
    }

    @Test
    public void testAddMessage_Update_ThenRetrieve() throws Exception {
        Message m = new Message("Hello World");
        addMessage(m);
        m.setText("Goodbye World");
        List<Message> messages = getMessages();

        assertThat(messages, hasSize(1));
        assertThat(messages, contains(new Message(1L, "Goodbye World")));
    }

    @Test
    public void testAddMessageThenUpdateOutsideContext_DoesntChangePersistence() throws Exception {
        Message m = new Message("Hello World");
        addMessage(m);
        em.close();
        em = emf.createEntityManager();
        m.setText("Goodbye World");
        List<Message> messages = getMessages();

        assertThat(messages, hasSize(1));
        assertThat(messages, contains(new Message(1L, "Hello World")));

    }

    private void addMessage(Message m) throws Exception {
        UserTransaction tx = TM.getUserTransaction();
        tx.begin();
        em.persist(m);
        tx.commit();
    }

    private void addMessage(String text) throws Exception {
        addMessage(new Message(text));
    }

    private List<Message> getMessages() throws Exception {
        UserTransaction tx = TM.getUserTransaction();
        tx.begin();
        List<Message> messages = em.createQuery("select m from Message m").getResultList();
        tx.commit();
        return messages;
    }

    private static void updateMessage(Message m, String newText) throws Exception {
        UserTransaction tx = TM.getUserTransaction();
        tx.begin();
        m.setText(newText);
        tx.commit();
    }

}
