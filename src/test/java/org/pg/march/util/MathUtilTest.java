package org.pg.march.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class MathUtilTest {

	private MathUtil mathUtil;

	@Before
	public void setup() {
		mathUtil = new MathUtil();
	}

	@Test
	public void testcase1() {
		Assert.assertEquals(87178291200L, mathUtil.factorial(14));
	}

	@Test
	public void testcase2() {
		Assert.assertEquals(16383L, mathUtil.allPossibleCombination(14));

		List<Integer>[] myList = new List[10];
		List<Integer>[] clonedList = myList.clone();
	}

	@Test
	public void testcase3() {
		Set<Double> e2 = new HashSet<>();
		System.out.println(sum());
		System.out.println(min(15));
		
	}
	
	@Test
	public void testcase4() {
		System.err.println("".getClass().getSimpleName());
	}
	
	private <E> Set<E> union(Set<? extends E> e1, Set<? extends E> e2) {
		Set<E> res = new HashSet<>();
		res.addAll(e1);
		res.addAll(e2);
		return res;
	}
	
	private int sum(int... args) {
		int sum = 0;
		for(int arg : args) {
			sum += arg;
		}
		return sum;
	}
	
	private int min(int num, int... args) {
		int min = num;
		for(int arg : args) {
			min = Math.min(arg, min);
		}
		return min;
	}
}
