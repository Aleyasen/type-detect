/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import type.detect.kb.freebase.FreebaseSuite;
import type.detect.kb.knowledgegraph.KnowledgegraphSuite;
import type.detect.kb.sparql.SparqlSuite;
import type.detect.kb.wikidata.WikidataSuite;

/**
 *
 * @author Amir
 */
public class KbSuite extends TestCase {
    
    public KbSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("KbSuite");
        suite.addTest(WikidataSuite.suite());
        suite.addTest(KnowledgegraphSuite.suite());
        suite.addTest(SparqlSuite.suite());
        suite.addTest(FreebaseSuite.suite());
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
    
}
