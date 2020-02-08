package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class PalindromePairsTest {

    private PalindromePairs palindromePairs;

    @Before
    public void setup() {
        palindromePairs = new PalindromePairs();
    }

    @Test
    public void testcase1() {
        String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
        List<List<Integer>> pairs = palindromePairs.palindromePairs(words);
        System.out.println(pairs);
        List<List<Integer>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList(0, 1));
        expected.add(Lists.newArrayList(1, 0));
        expected.add(Lists.newArrayList(3, 2));
        expected.add(Lists.newArrayList(2, 4));
        CollectionUtilTest.assertIgnoreOrderListOfList(expected, pairs);
    }

    @Test
    public void testcase2() {
        String[] words = { "bat", "tab", "cat" };
        List<List<Integer>> pairs = palindromePairs.palindromePairs(words);
        List<List<Integer>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList(0, 1));
        expected.add(Lists.newArrayList(1, 0));
        CollectionUtilTest.assertIgnoreOrderListOfList(expected, pairs);
    }
    
    @Test
    public void testcase3() {
        String[] words = { "aaa", "a"};
        List<List<Integer>> pairs = palindromePairs.palindromePairs(words);
        System.out.println(pairs);
        List<List<Integer>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList(0, 1));
        expected.add(Lists.newArrayList(1, 0));
        CollectionUtilTest.assertIgnoreOrderListOfList(expected, pairs);
    }
    
    @Test
    public void testcase4() {
        String[] words = { "bat", "tab"};
        List<List<Integer>> pairs = palindromePairs.palindromePairs(words);
        System.out.println(pairs);
        List<List<Integer>> expected = Lists.newArrayList();
        expected.add(Lists.newArrayList(0, 1));
        expected.add(Lists.newArrayList(1, 0));
        CollectionUtilTest.assertIgnoreOrderListOfList(expected, pairs);
    }
}
