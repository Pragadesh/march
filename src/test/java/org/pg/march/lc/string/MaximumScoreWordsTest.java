package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MaximumScoreWordsTest {

	private MaximumScoreWords maximumScoreWords;

	@Before
	public void setup() {
		maximumScoreWords = new MaximumScoreWords();
	}

	@Test
	public void testcase1() {
		String[] words = { "dog", "cat", "dad", "good" };
		char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
		int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Assert.assertEquals(23, maximumScoreWords.maxScoreWords(words, letters, score));
	}

	@Test
	public void testcase2() {
		String[] words = { "xxxz", "ax", "bx", "cx" };
		char[] letters = { 'z', 'a', 'b', 'c', 'x', 'x', 'x' };
		int[] score = { 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10 };
		Assert.assertEquals(27, maximumScoreWords.maxScoreWords(words, letters, score));
	}

	@Test
	public void testcase3() {
		String[] words = { "leetcode" };
		char[] letters = { 'l', 'e', 't', 'c', 'o', 'd' };
		int[] score = { 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 };
		Assert.assertEquals(0, maximumScoreWords.maxScoreWords(words, letters, score));
	}
}
