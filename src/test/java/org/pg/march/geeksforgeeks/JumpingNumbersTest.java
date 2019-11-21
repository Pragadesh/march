package org.pg.march.geeksforgeeks;

import static org.pg.march.geeksforgeeks.JumpingNumbers.getJumpingNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;

import junit.framework.Assert;

public class JumpingNumbersTest {

    
    @Test
    public void testcase1() {
        List<Integer> result = getJumpingNumbers(10);
        Assert.assertNotNull(result);
        List<Integer> expectedResult = Stream.of("0 1 2 3 4 5 6 7 8 9 10".split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Assert.assertEquals(true, CollectionUtil.containsAll(expectedResult, result));
    }
    
    @Test
    public void testcase2() {
        List<Integer> result = getJumpingNumbers(50);
        Assert.assertNotNull(result);
        List<Integer> expectedResult = Stream.of("0 1 2 3 4 5 6 7 8 9 10 12 21 23 32 34 43 45".split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Assert.assertEquals(true, CollectionUtil.containsAll(expectedResult, result));
    }
}
