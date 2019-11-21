package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ReplaceStringForBalancedStringTest {

    private ReplaceStringForBalancedString replaceStringForBalancedString;

    @Before
    public void setup() {
        replaceStringForBalancedString = new ReplaceStringForBalancedString();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(0, replaceStringForBalancedString.balancedString("QWER"));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals(1, replaceStringForBalancedString.balancedString("QQWE"));
    }
    
    @Test
    public void testcase3() {
        Assert.assertEquals(2, replaceStringForBalancedString.balancedString("QQQW"));
    }
    
    @Test
    public void testcase4() {
        Assert.assertEquals(3, replaceStringForBalancedString.balancedString("QQQQ"));
    }
    
    @Test
    public void testcase5() {
        Assert.assertEquals(2, replaceStringForBalancedString.balancedString("RQRERREWEEWWQWRRRWQQEQQQ"));
    }
}
