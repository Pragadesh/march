package org.pg.march.lc.num;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MajorityElementTest {

    private MajorityElement majorityElement;

    @Before
    public void setup() {
        majorityElement = new MajorityElement();
    }

    @Test
    public void testcase1() {
        Assert.assertEquals(3, majorityElement.majorityElement(new int[] { 3, 2, 3 }));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(2, majorityElement.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
    }
}
