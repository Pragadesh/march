package org.pg.march.lc.string;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BraceExpansionTest {

    private BraceExpansion braceExpansion;

    @Before
    public void setup() {
        braceExpansion = new BraceExpansion();
    }

    @Test
    public void testcase1() {
        String[] words = toArr(braceExpansion.braceExpansionII("{a,b}c{d,e}f"));
        String[] expected = { "acdf", "acef", "bcdf", "bcef" };
        Assert.assertArrayEquals(expected, words);
    }

    @Test
    public void testcase2() {
        String[] words = toArr(braceExpansion.braceExpansionII("abcd"));
        String[] expected = { "abcd" };
        Assert.assertArrayEquals(expected, words);
    }
    
    @Test
    public void testcase3() {
        String[] words = toArr(braceExpansion.braceExpansionII("{a}{a}{a}"));
        String[] expected = { "aaa" };
        Assert.assertArrayEquals(expected, words);
    }
    
    @Test
    public void testcase4() {
        String[] words = toArr(braceExpansion.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
        System.out.println(Arrays.toString(words));
        String[] expected = { "a","ab","ac","z" };
        Assert.assertArrayEquals(expected, words);
    }
    
    private String[] toArr(List<String> values) {
    	String[] arr = new String[values.size()];
    	return values.toArray(arr);
    }
    
}
