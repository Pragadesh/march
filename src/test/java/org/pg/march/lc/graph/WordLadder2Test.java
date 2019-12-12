package org.pg.march.lc.graph;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtilTest;

import com.google.common.collect.Lists;


public class WordLadder2Test {

	private WordLadder2 wordLadder2;

	@Before
	public void setup() {
		wordLadder2 = new WordLadder2();
	}

	@Test
	public void testcase1() {
		List<String> wordList = Lists.newArrayList("hot", "dot", "dog", "lot", "log", "cog");
		List<List<String>> result = wordLadder2.findLadders("hit", "cog", wordList);
		List<List<String>> expectedList = Lists.newArrayList();
		expectedList.add(Lists.newArrayList("hit","hot","dot","dog","cog"));
		expectedList.add(Lists.newArrayList("hit","hot","lot","log","cog"));
		CollectionUtilTest.assertIgnoreOrderListOfList(expectedList, result);
	}

	@Test
	public void testcase2() {
		List<String> wordList = Lists.newArrayList("hot", "dot", "dog", "lot", "log");
		List<List<String>> result = wordLadder2.findLadders("hit", "cog", wordList);
		List<List<String>> expectedList = Lists.newArrayList();
		CollectionUtilTest.assertIgnoreOrderListOfList(expectedList, result);
	}
	
	@Test
	public void testTransformationMap1() {
		String word = "mix";
		wordLadder2.createTransformationMap(Lists.newArrayList(word));
	}
}
