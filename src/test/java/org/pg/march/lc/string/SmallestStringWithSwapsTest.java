package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class SmallestStringWithSwapsTest {

    private SmallestStringWithSwaps smallestStringWithSwaps;

    @Before
    public void setup() {
        smallestStringWithSwaps = new SmallestStringWithSwaps();
    }

    @Test
    public void testcase1() {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Lists.newArrayList(0, 3));
        pairs.add(Lists.newArrayList(1, 2));
        Assert.assertEquals("bacd", smallestStringWithSwaps.smallestStringWithSwaps("dcab", pairs));
    }

    @Test
    public void testcase2() {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Lists.newArrayList(0, 3));
        pairs.add(Lists.newArrayList(1, 2));
        pairs.add(Lists.newArrayList(0, 2));
        Assert.assertEquals("abcd", smallestStringWithSwaps.smallestStringWithSwaps("dcab", pairs));
    }

    @Test
    public void testcase3() {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Lists.newArrayList(0, 1));
        pairs.add(Lists.newArrayList(1, 2));
        Assert.assertEquals("abc", smallestStringWithSwaps.smallestStringWithSwaps("cba", pairs));
    }
}
