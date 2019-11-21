package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RemoveAdjacentDuplicatesInString2Test {

    private RemoveAdjacentDuplicatesInString2 removeAdjacentDuplicatesInString2;

    @Before
    public void setup() {
        removeAdjacentDuplicatesInString2 = new RemoveAdjacentDuplicatesInString2();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals("abcd", removeAdjacentDuplicatesInString2.removeDuplicates("abcd", 2));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals("aa", removeAdjacentDuplicatesInString2.removeDuplicates("deeedbbcccbdaa", 3));
    }
    
    @Test
    public void testcase3() {
        Assert.assertEquals("ps", removeAdjacentDuplicatesInString2.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
