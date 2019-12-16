package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class AlienDictionaryTest {

    private AlienDictionary alienDictionary;

    @Before
    public void setup() {
        alienDictionary = new AlienDictionary();
    }

    @Test
    public void testcase1() {
        String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
        Assert.assertEquals("wertf", alienDictionary.alienOrder(words));
    }

    @Test
    public void testcase2() {
        String[] words = { "z", "x" };
        Assert.assertEquals("zx", alienDictionary.alienOrder(words));
    }

    @Test
    public void testcase3() {
        String[] words = { "z", "x", "z" };
        Assert.assertEquals("", alienDictionary.alienOrder(words));
    }
    
    @Test
    public void testcase4() {
        String[] words = { "wrz", "wb" };
        Assert.assertEquals("wrzb", alienDictionary.alienOrder(words));
    }
    
    @Test
    public void testcase5() {
        String[] words = { "wrt", "wrt" };
        Assert.assertEquals("wrt", alienDictionary.alienOrder(words));
    }
}
