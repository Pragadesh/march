package org.pg.march.lc.num;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class CountSmallerNumbersAfterSelfTest {

    private CountSmallerNumbersAfterSelf countSmallerNumbersAfterSelf;

    @Before
    public void setup() {
        countSmallerNumbersAfterSelf = new CountSmallerNumbersAfterSelf();
    }

    @Test
    public void testcase1() {
        int[] nums = { 5, 2, 6, 1 };
        List<Integer> result = countSmallerNumbersAfterSelf.countSmaller(nums);
        List<Integer> expected = Lists.newArrayList(2,1,1,0);
        Assert.assertEquals(expected, result);
    }
}
