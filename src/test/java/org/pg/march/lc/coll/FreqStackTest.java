package org.pg.march.lc.coll;

import org.junit.Test;

import junit.framework.Assert;

public class FreqStackTest {

	@Test
	public void testcase1() {
		FreqStack stack = new FreqStack();
		stack.push(5);
		stack.push(7);
		stack.push(5);
		stack.push(7);
		stack.push(4);
		stack.push(5);
		//5,7,5,7,4,5
		Assert.assertEquals(5, stack.pop());
		Assert.assertEquals(7, stack.pop());
		Assert.assertEquals(5, stack.pop());
		Assert.assertEquals(4, stack.pop());
	}
}
