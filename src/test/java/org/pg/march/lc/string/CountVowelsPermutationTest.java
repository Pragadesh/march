package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CountVowelsPermutationTest {

    private CountVowelsPermutation countVowelsPermutation;

    @Before
    public void setup() {
        countVowelsPermutation = new CountVowelsPermutation();
    }

    @Test
    public void testcase1() {
        System.out.println(Integer.MAX_VALUE);
        Assert.assertEquals(5, countVowelsPermutation.countVowelPermutation(1));
    }

    @Test
    public void testcase2() {
        Assert.assertEquals(10, countVowelsPermutation.countVowelPermutation(2));
    }

    @Test
    public void testcase3() {
        Assert.assertEquals(68, countVowelsPermutation.countVowelPermutation(5));
    }
}
