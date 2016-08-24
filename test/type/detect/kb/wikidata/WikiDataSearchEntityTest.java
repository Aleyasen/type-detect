/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.wikidata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Amir
 */
public class WikiDataSearchEntityTest extends TestCase {
    
    public WikiDataSearchEntityTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(WikiDataSearchEntityTest.class);
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
     * Test of getId method, of class WikiDataSearchEntity.
     */
    public void testGetId() {
        System.out.println("getId");
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class WikiDataSearchEntity.
     */
    public void testSetId() {
        System.out.println("setId");
        String id = "";
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUrl method, of class WikiDataSearchEntity.
     */
    public void testGetUrl() {
        System.out.println("getUrl");
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        String expResult = "";
        String result = instance.getUrl();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUrl method, of class WikiDataSearchEntity.
     */
    public void testSetUrl() {
        System.out.println("setUrl");
        String url = "";
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        instance.setUrl(url);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLabel method, of class WikiDataSearchEntity.
     */
    public void testGetLabel() {
        System.out.println("getLabel");
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        String expResult = "";
        String result = instance.getLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLabel method, of class WikiDataSearchEntity.
     */
    public void testSetLabel() {
        System.out.println("setLabel");
        String label = "";
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        instance.setLabel(label);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class WikiDataSearchEntity.
     */
    public void testGetType() {
        System.out.println("getType");
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class WikiDataSearchEntity.
     */
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class WikiDataSearchEntity.
     */
    public void testToString() {
        System.out.println("toString");
        WikiDataSearchEntity instance = new WikiDataSearchEntity();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
