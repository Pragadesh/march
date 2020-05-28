package org.pg.march.lc.design;

import org.junit.Test;

public class AutocompleteSystemTest {

	@Test
	public void testcase1() {
		String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
		int[] times = {5,3,2,2};
		AutocompleteSystem autoComplete = new AutocompleteSystem(sentences, times);
		System.out.println(autoComplete.input('i'));
		System.out.println(autoComplete.input(' '));
		System.out.println(autoComplete.input('a'));
		System.out.println(autoComplete.input('#'));
	}
}
