package com.martinrist.hibernate.shared;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Starts and stops the transaction manager/database pool before/after a test suite.
 * <p>
 * All tests in a suite execute with a single {@link TransactionManagerSetup}, call
 * the static {@link TransactionManagerTest#TM} in your test to access the JTA
 * transaction manager and database connections.
 * </p>
 * <p>
 * The test parameters <code>database</code> (specifying a supported
 * {@link DatabaseProduct}) and a <code>connectionURL</code> are optional.
 * The default is an in-memory H2 database instance, created and destroyed
 * automatically for each test suite.
 * </p>
 */
public class TransactionManagerTest {

    // Static single database connection manager per test suite
    static public TransactionManagerSetup TM;

    @BeforeClass
    public static void beforeSuite() throws Exception {
        TM = new TransactionManagerSetup(DatabaseProduct.H2);
    }

    @AfterClass
    public static void afterSuite() throws Exception {
        if (TM != null)
            TM.stop();
    }
}
