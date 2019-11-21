package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class SubstringConcatenationAllWordsTest {

    private SubstringConcatenationAllWords substringConcatenationAllWords;

    @Before
    public void setup() {
        substringConcatenationAllWords = new SubstringConcatenationAllWords();
    }

    @Test
    public void testcase1() {
        String[] words = new String[] { "foo", "bar" };
        List<Integer> subMatches = substringConcatenationAllWords.findSubstring("barfoothefoobarman", words);
        List<Integer> expected = Lists.newArrayList(0, 9);
        CollectionUtilTest.assertIgnoreOrderList(expected, subMatches);
    }

    @Test
    public void testcase2() {
        String[] words = new String[] { "word", "good", "best", "good" };
        List<Integer> subMatches = substringConcatenationAllWords.findSubstring("wordgoodgoodgoodbestword", words);
        List<Integer> expected = Lists.newArrayList(8);
        CollectionUtilTest.assertIgnoreOrderList(expected, subMatches);
    }
    
    @Test
    public void testcase3() {
        String[] words = new String[] { "bar", "foo", "the" };
        List<Integer> subMatches = substringConcatenationAllWords.findSubstring("barfoofoobarthefoobarman", words);
        List<Integer> expected = Lists.newArrayList(6, 9, 12);
        CollectionUtilTest.assertIgnoreOrderList(expected, subMatches);
    }
    
    @Test
    public void testcase4() {
        String[] words = new String[] { "sea","tea","ate" };
        List<Integer> subMatches = substringConcatenationAllWords.findSubstring("sheateateseatea", words);
        List<Integer> expected = Lists.newArrayList(6);
        CollectionUtilTest.assertIgnoreOrderList(expected, subMatches);
    }
}
