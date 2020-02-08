package org.pg.march.lc.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompareStringsByFrequencyTest {

    private CompareStringsByFrequency compareStringsByFrequency;

    @Before
    public void setup() {
        compareStringsByFrequency = new CompareStringsByFrequency();
    }

    @Test
    public void testcase1() {
        String[] queries = { "cbd" };
        String[] words = { "zaaaz" };
        int[] frequency = compareStringsByFrequency.numSmallerByFrequency(queries, words);
        int[] expected = { 1 };
        Assert.assertArrayEquals(expected, frequency);
    }

    @Test
    public void testcase2() {
        String[] queries = { "bbb", "cc" };
        String[] words = { "a", "aa", "aaa", "aaaa" };
        int[] frequency = compareStringsByFrequency.numSmallerByFrequency(queries, words);
        int[] expected = { 1, 2 };
        Assert.assertArrayEquals(expected, frequency);
    }
}
