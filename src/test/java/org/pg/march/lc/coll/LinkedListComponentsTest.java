package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;

import junit.framework.Assert;

public class LinkedListComponentsTest {

	private LinkedListComponents linkedListComponents;

	@Before
	public void setup() {
		linkedListComponents = new LinkedListComponents();
	}

	@Test
	public void testcase1() {
		int[] nums = { 0, 1, 2, 3 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		Assert.assertEquals(2, linkedListComponents.numComponents(head, new int[] { 0, 1, 3 }));
	}

	@Test
	public void testcase2() {
		int[] nums = { 0, 1, 2, 3, 4 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		Assert.assertEquals(2, linkedListComponents.numComponents(head, new int[] { 0, 3, 1, 4 }));
	}
	
	@Test
	public void testcase3() {
		Assert.assertEquals(0, linkedListComponents.numComponents(null, new int[] { 0, 3, 1, 4 }));
		int[] nums = { 0, 1, 2, 3 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		Assert.assertEquals(0, linkedListComponents.numComponents(head, null));
	}
}
