package org.pg.march.lc.string;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class EditDistanceTest {

	private EditDistance editDistance;

	@Before
	public void setup() {
		editDistance = new EditDistance();
	}

	/*
	 * horse -> rorse (replace 'h' with 'r')
	 * rorse -> rose (remove 'r')
	 * rose -> ros (remove 'e')
	 */
	@Test
	public void testcase1() {
		Assert.assertEquals(3, editDistance.minDistance("horse", "ros"));
	}
	
	
	/*
	 * intention -> inention (remove 't')
	 * inention -> enention (replace 'i' with 'e')
	 * enention -> exention (replace 'n' with 'x')
	 * exention -> exection (replace 'n' with 'c')
	 * exection -> execution (insert 'u')
	 */
	@Test
	public void testcase2() {
		Assert.assertEquals(5, editDistance.minDistance("intention", "execution"));
	}
}
