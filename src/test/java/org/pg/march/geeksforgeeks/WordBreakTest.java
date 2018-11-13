package org.pg.march.geeksforgeeks;

import static org.pg.march.geeksforgeeks.WordBreak.recursiveSplit;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import junit.framework.Assert;

public class WordBreakTest {

    @Test
    public void testCase1() {
        Set<String> dictWords = Stream.of("i like sam sung samsung mobile ice cream icecream man go mango".split(" ")).collect(Collectors.toSet());
        Assert.assertEquals(1, recursiveSplit(1, "ilike", dictWords));
        Assert.assertEquals(0, recursiveSplit(1, "idontlike", dictWords));
    }
}
