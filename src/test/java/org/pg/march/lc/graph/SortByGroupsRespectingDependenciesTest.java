package org.pg.march.lc.graph;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class SortByGroupsRespectingDependenciesTest {

    private SortByGroupsRespectingDependencies sortByGroupsRespectingDependencies;

    @Before
    public void setup() {
        sortByGroupsRespectingDependencies = new SortByGroupsRespectingDependencies();
    }

    @Test
    public void testcase1() {
        List<Integer> EMPTY = Lists.newArrayList();
        List<List<Integer>> beforeItems = Lists.newArrayList(EMPTY, Lists.newArrayList(6), Lists.newArrayList(5), Lists.newArrayList(6),
                Lists.newArrayList(3, 6), EMPTY, EMPTY, EMPTY);
        int[] group = new int[] { -1, -1, 1, 0, 0, 1, 0, -1 };
        int[] sortItems = sortByGroupsRespectingDependencies.sortItems(8, 2, group, beforeItems);
        Assert.assertArrayEquals(new int[] { 6, 3, 4, 1, 5, 2, 0, 7 }, sortItems);
    }

    @Test
    public void testcase2() {
        List<Integer> EMPTY = Lists.newArrayList();
        List<List<Integer>> beforeItems = Lists.newArrayList(EMPTY, Lists.newArrayList(6), Lists.newArrayList(5), Lists.newArrayList(6),
                Lists.newArrayList(3), EMPTY, Lists.newArrayList(4), EMPTY);
        int[] group = new int[] { -1, -1, 1, 0, 0, 1, 0, -1 };
        int[] sortItems = sortByGroupsRespectingDependencies.sortItems(8, 2, group, beforeItems);
        Assert.assertArrayEquals(new int[] {}, sortItems);
    }

}
