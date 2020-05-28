package org.pg.march.lc.string;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import junit.framework.Assert;

public class SplitArrayIntoFibonacciSequenceTest {

	private SplitArrayIntoFibonacciSequence splitArrayIntoFibonacciSequence;

	@Before
	public void setup() {
		splitArrayIntoFibonacciSequence = new SplitArrayIntoFibonacciSequence();
	}

	@Test
	public void testcase1() {
		List<Integer> answer = splitArrayIntoFibonacciSequence.splitIntoFibonacci("123456579");
		List<Integer> expected = Lists.newArrayList(123, 456, 579);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testcase2() {
		List<Integer> answer = splitArrayIntoFibonacciSequence.splitIntoFibonacci("11235813");
		List<Integer> expected = Lists.newArrayList(1, 1, 2, 3, 5, 8, 13);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testcase3() {
		List<Integer> answer = splitArrayIntoFibonacciSequence.splitIntoFibonacci("112358130");
		List<Integer> expected = Lists.newArrayList();
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testcase4() {
		List<Integer> answer = splitArrayIntoFibonacciSequence.splitIntoFibonacci("1101111");
		List<Integer> expected = Lists.newArrayList(11, 0, 11, 11);
		Assert.assertEquals(expected, answer);
	}

	@Test
	public void testcase5() {
		List<Integer> answer = splitArrayIntoFibonacciSequence.splitIntoFibonacci("17522");
		List<Integer> expected = Lists.newArrayList(17, 5, 22);
		Assert.assertEquals(expected, answer);
	}
	
	@Test
	public void testcase6() {
		List<Integer> answer = splitArrayIntoFibonacciSequence.splitIntoFibonacci("0123");
		List<Integer> expected = Lists.newArrayList();
		Assert.assertEquals(expected, answer);
	}
}
