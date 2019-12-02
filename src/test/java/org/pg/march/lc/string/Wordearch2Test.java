package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;

public class Wordearch2Test {

	private Wordearch2 wordearch2;

    @Before
    public void setup() {
        wordearch2 = new Wordearch2();
    }

    @Test
    public void testcase1() {
		char[][] board = { { 'o', 'a', 'a', 'n' },
				{ 'e', 't', 'a', 'e' },
				{ 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> matched = wordearch2.findWords(board, words);
		List<String> expected = Lists.newArrayList("eat", "oath");
		CollectionUtilTest.assertIgnoreOrderList(expected, matched);
    }
}
