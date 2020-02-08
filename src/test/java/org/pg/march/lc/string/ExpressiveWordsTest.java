package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ExpressiveWordsTest {

    private ExpressiveWords expressiveWords;

    @Before
    public void setup() {
        expressiveWords = new ExpressiveWords();
    }

    @Test
    public void testcase1() {
        String[] words = { "hello", "hi", "helo" };
        Assert.assertEquals(1, expressiveWords.expressiveWords("heeellooo", words));
    }
    
    @Test
    public void testcase2() {
        String[] words = { "hello"};
        Assert.assertEquals(1, expressiveWords.expressiveWords("heeellooo", words));
    }
}
