package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SplitBalancedStringsTest {

    private SplitBalancedStrings splitBalancedStrings;

    @Before
    public void setup() {
        splitBalancedStrings = new SplitBalancedStrings();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(4, splitBalancedStrings.balancedStringSplit("RLRRLLRLRL"));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals(3, splitBalancedStrings.balancedStringSplit("RLLLLRRRLR"));
    }
    
    @Test
    public void testcase3() {
        Assert.assertEquals(1, splitBalancedStrings.balancedStringSplit("LLLLRRRR"));
    }
}
