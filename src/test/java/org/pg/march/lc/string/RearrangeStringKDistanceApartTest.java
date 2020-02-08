package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class RearrangeStringKDistanceApartTest {

	
	private RearrangeStringKDistanceApart rearrangeStringKDistanceApart;

    @Before
    public void setup() {
        rearrangeStringKDistanceApart = new RearrangeStringKDistanceApart();
    }

    @Test
    public void testcase1() {
    	Assert.assertEquals("abcabc", rearrangeStringKDistanceApart.rearrangeString("aabbcc", 3));
    }
    
    @Test
    public void testcase2() {
    	Assert.assertEquals("", rearrangeStringKDistanceApart.rearrangeString("aaabc", 3));
    }
    
    @Test
    public void testcase3() {
    	Assert.assertEquals("abacabcd", rearrangeStringKDistanceApart.rearrangeString("aaadbbcc", 2));
    }
    
    @Test
    public void testcase4() {
    	Assert.assertEquals("a", rearrangeStringKDistanceApart.rearrangeString("a", 0));
    }
    
    @Test
    public void testcase5() {
    	Assert.assertEquals("a", rearrangeStringKDistanceApart.rearrangeString("a", 2));
    }
}
