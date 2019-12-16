package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BasicCalculator3Test {

    private BasicCalculator3 basicCalculator3;

    @Before
    public void setup() {
        basicCalculator3 = new BasicCalculator3();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(2, basicCalculator3.calculate("1 + 1"));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(4, basicCalculator3.calculate(" 6-4 / 2 "));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(21, basicCalculator3.calculate("2*(5+5*2)/3+(6/2+8)"));
    }

    @Test
    public void testcase4() {
        Assert.assertEquals(12, basicCalculator3.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }
}
