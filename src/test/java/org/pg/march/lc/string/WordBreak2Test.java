package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class WordBreak2Test {

	private WordBreak2 wordBreak2;

	@Before
	public void setup() {
		wordBreak2 = new WordBreak2();
	}

	@Test
	public void testcase1() {
		List<String> wordDict = Lists.newArrayList("cat", "cats", "and", "sand", "dog");
		List<String> sentences = wordBreak2.wordBreak("catsanddog", wordDict);
		List<String> expected = Lists.newArrayList("cats and dog", "cat sand dog");
		Assert.assertEquals(expected, sentences);
	}
	
	@Test
	public void testcase2() {
		List<String> wordDict = Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		List<String> sentences = wordBreak2.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict);
		System.out.println(sentences);
//		List<String> expected = Lists.newArrayList("cats and dog", "cat sand dog");
//		Assert.assertEquals(expected, sentences);
	}
	
	@Test
	public void testcase3() {
		List<String> wordDict = Lists.newArrayList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		List<String> sentences = wordBreak2.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict);
		System.out.println(sentences);
//		List<String> expected = Lists.newArrayList("cats and dog", "cat sand dog");
//		Assert.assertEquals(expected, sentences);
	}
}
