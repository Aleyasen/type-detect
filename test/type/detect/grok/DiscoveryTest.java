/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.grok;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import type.detect.grok.exception.GrokException;

/**
 *
 * @author Amir
 */
public class DiscoveryTest {

    public DiscoveryTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void dtest() {
        try {
            Grok g = Grok.create(ResourceManager.PATTERNS);
            Discovery disc = new Discovery(g);

            final String out = disc.discover("amir@gmail.com 1234 1997 Monday");
            System.out.println("discover=" + out);

        } catch (GrokException ex) {
            Logger.getLogger(DiscoveryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
