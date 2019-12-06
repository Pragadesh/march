package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;

public class ReverseNodesInGroupTest {

	private ReverseNodesInGroup reverseNodesInGroup;

	@Before
	public void setup() {
		reverseNodesInGroup = new ReverseNodesInGroup();
	}

	@Test
	public void testcase1() {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseNodesInGroup.reverseKGroup(head, 2);
		System.out.println(CollectionUtil.traverseLinkedList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 2, 1, 4, 3, 5 }, reverseHead);
	}

	@Test
	public void testcase2() {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseNodesInGroup.reverseKGroup(head, 3);
		System.out.println(CollectionUtil.traverseLinkedList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 3, 2, 1, 4, 5 }, reverseHead);
	}
	
	@Test
	public void testcase3() {
		int[] nums = { 1, 2, 3};
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseNodesInGroup.reverseKGroup(head, 3);
		System.out.println(CollectionUtil.traverseLinkedList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 3, 2, 1 }, reverseHead);
	}
}
