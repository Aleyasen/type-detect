/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import junit.framework.TestCase;

/**
 *
 * @author Amir
 */
public class TypeDetectTest extends TestCase {

    public TypeDetectTest(String testName) {
        super(testName);
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
     * Test of main method, of class TypeDetect.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TypeDetect.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of besttype method, of class TypeDetect.
     */
    public void testBesttype_String() {
        System.out.println("besttype");
        String text = "";
        TypeDetect instance = new TypeDetect();
        String expResult = "";
        String result = instance.besttype(text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of besttype method, of class TypeDetect.
     */
    public void testBesttype_List() {
        System.out.println("besttype");
        List<String> list = Arrays.asList("ITGB3", "ERBB2", "CTLA4");
        TypeDetect instance = new TypeDetect();
        String result = instance.besttype(list);
        assertEquals("protein-coding gene", result);
    }

    public void testBesttype_List2() {
        System.out.println("besttype");
        List<String> list = Arrays.asList("Klebsiella", "Escherichia coli", "Bacteria and protozoa", "Neisseria meningitidis");
        TypeDetect instance = new TypeDetect();
        String result = instance.besttype(list);
        assertEquals("taxon", result);
//        System.out.println(result);
    }

    /**
     * Test of besttype method, of class TypeDetect.
     */
    public void testBesttype_Set() {
        System.out.println("besttype");
        Set<String> set = null;
        TypeDetect instance = new TypeDetect();
        String expResult = "";
        String result = instance.besttype(set);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
