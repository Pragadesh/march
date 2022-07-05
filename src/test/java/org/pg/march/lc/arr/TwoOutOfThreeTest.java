package org.pg.march.lc.arr;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import java.util.List;

public class TwoOutOfThreeTest {

    private TwoOutOfThree twoOutOfThree;

    @Before
    public void setup() {
        twoOutOfThree = new TwoOutOfThree();
    }

    @Test
    public void testcase1() {
        List<Integer> result = twoOutOfThree.twoOutOfThree(new int[] {1,1,3,2}, new int[] {2,3}, new int[] {3});
        CollectionUtilTest.assertIgnoreOrderList(Lists.newArrayList(3,2), result);
    }

    @Test
    public void testcase2() {
        List<Integer> result = twoOutOfThree.twoOutOfThree(new int[] {3,1}, new int[] {2,3}, new int[] {1,2});
        CollectionUtilTest.assertIgnoreOrderList(Lists.newArrayList(2,3,1), result);
    }

    @Test
    public void testcase3() {
        List<Integer> result = twoOutOfThree.twoOutOfThree(new int[] {1,2,2}, new int[] {4,3,3}, new int[] {5});
        CollectionUtilTest.assertIgnoreOrderList(Lists.newArrayList(), result);
    }
}
