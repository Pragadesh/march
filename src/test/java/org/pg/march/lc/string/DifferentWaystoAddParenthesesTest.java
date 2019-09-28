package org.pg.march.lc.string;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DifferentWaystoAddParenthesesTest {

    private DifferentWaystoAddParentheses differentWaystoAddParentheses;

    @Before
    public void setup() {
        differentWaystoAddParentheses = new DifferentWaystoAddParentheses();
    }

    @Test
    public void testcase1() {
        List<Integer> outputs = differentWaystoAddParentheses.diffWaysToCompute("2-1-1");
        Integer[] expected = { 0, 2 };
        Assert.assertNotNull(outputs);
        Assert.assertArrayEquals(expected, outputs.toArray(new Integer[outputs.size()]));
    }

    @Test
    public void testcase2() {
        List<Integer> outputs = differentWaystoAddParentheses.diffWaysToCompute("2*3-4*5");
        Integer[] expected = { -34, -14, -10, -10, 10 };
        Assert.assertNotNull(outputs);
        Assert.assertArrayEquals(expected, outputs.toArray(new Integer[outputs.size()]));
    }
}
