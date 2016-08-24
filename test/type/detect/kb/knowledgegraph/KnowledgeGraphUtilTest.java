/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.knowledgegraph;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.json.simple.JSONArray;

/**
 *
 * @author Amir
 */
public class KnowledgeGraphUtilTest extends TestCase {
    
    public KnowledgeGraphUtilTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(KnowledgeGraphUtilTest.class);
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
     * Test of main method, of class KnowledgeGraphUtil.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        KnowledgeGraphUtil.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class KnowledgeGraphUtil.
     */
    public void testGetType() {
        System.out.println("getType");
        String query = "";
        String expResult = "";
        String result = KnowledgeGraphUtil.getType(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class KnowledgeGraphUtil.
     */
    public void testGetResult() {
        System.out.println("getResult");
        String query = "";
        JSONArray expResult = null;
        JSONArray result = KnowledgeGraphUtil.getResult(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
