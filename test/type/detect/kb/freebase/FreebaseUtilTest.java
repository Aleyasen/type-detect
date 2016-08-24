/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.freebase;

import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.sf.json.JSONArray;

/**
 *
 * @author Amir
 */
public class FreebaseUtilTest extends TestCase {
    
    public FreebaseUtilTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(FreebaseUtilTest.class);
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
     * Test of main method, of class FreebaseUtil.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        FreebaseUtil.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class FreebaseUtil.
     */
    public void testSearch() {
        System.out.println("search");
        String query = "";
        String mql_query_file = "";
        int limit = 0;
        JSONArray expResult = null;
        JSONArray result = FreebaseUtil.search(query, mql_query_file, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetch method, of class FreebaseUtil.
     */
    public void testFetch() {
        System.out.println("fetch");
        String query_template_file = "";
        Map<String, String> params = null;
        JSONArray expResult = null;
        JSONArray result = FreebaseUtil.fetch(query_template_file, params);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
