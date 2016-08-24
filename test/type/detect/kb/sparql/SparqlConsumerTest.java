/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.sparql;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Amir
 */
public class SparqlConsumerTest extends TestCase {
    
    public SparqlConsumerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SparqlConsumerTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of main method, of class SparqlConsumer.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SparqlConsumer.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of query method, of class SparqlConsumer.
     */
    public void testQuery() {
        System.out.println("query");
        String endpoint = "";
        String query = "";
        SparqlConsumer.query(endpoint, query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
