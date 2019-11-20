package org.pg.march.util;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MathUtilTest {

	
	private MathUtil mathUtil;

    @Before
    public void setup() {
        mathUtil = new MathUtil();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(87178291200L, mathUtil.factorial(14));
    }
    
    @Test
    public void testcase2() {
        Assert.assertEquals(16383L, mathUtil.allPossibleCombination(14));
    }
}
