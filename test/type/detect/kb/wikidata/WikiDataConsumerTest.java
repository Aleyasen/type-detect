/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.wikidata;

import java.util.List;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Amir
 */
public class WikiDataConsumerTest extends TestCase {
    
    public WikiDataConsumerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(WikiDataConsumerTest.class);
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
     * Test of main method, of class WikiDataConsumer.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        WikiDataConsumer.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypes method, of class WikiDataConsumer.
     */
    public void testGetTypes_List() {
        System.out.println("getTypes");
        List<String> terms = null;
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = WikiDataConsumer.getTypes(terms);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypes method, of class WikiDataConsumer.
     */
    public void testGetTypes_String() {
        System.out.println("getTypes");
        String term = "";
        Map<String, Integer> expResult = null;
        Map<String, Integer> result = WikiDataConsumer.getTypes(term);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBestType method, of class WikiDataConsumer.
     */
    public void testGetBestType_String() {
        System.out.println("getBestType");
        String term = "";
        String expResult = "";
        String result = WikiDataConsumer.getBestType(term);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBestType method, of class WikiDataConsumer.
     */
    public void testGetBestType_List() {
        System.out.println("getBestType");
        List<String> terms = null;
        String expResult = "";
        String result = WikiDataConsumer.getBestType(terms);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recognizeTypesForID method, of class WikiDataConsumer.
     */
    public void testRecognizeTypesForID() {
        System.out.println("recognizeTypesForID");
        String id = "";
        List<String> expResult = null;
        List<String> result = WikiDataConsumer.recognizeTypesForID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class WikiDataConsumer.
     */
    public void testSearch() {
        System.out.println("search");
        String query = "";
        List<WikiDataSearchEntity> expResult = null;
        List<WikiDataSearchEntity> result = WikiDataConsumer.search(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
