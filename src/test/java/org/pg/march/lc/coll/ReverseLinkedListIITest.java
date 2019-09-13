package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;

public class ReverseLinkedListIITest {

	private ReverseLinkedListII reverseLinkedListII;

	@Before
	public void setup() {
		reverseLinkedListII = new ReverseLinkedListII();
	}

	@Test
	public void testcase1() {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseLinkedListII.reverseBetween(head, 2, 4);
		System.out.println("Reversed: " + CollectionUtilTest.toList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 1, 4, 3, 2, 5 }, reverseHead);
	}

	@Test
	public void testcase2() {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseLinkedListII.reverseBetween(head, 1, 4);
		System.out.println("Reversed: " + CollectionUtilTest.toList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 4, 3, 2, 1, 5 }, reverseHead);
	}

	@Test
	public void testcase3() {
		int[] nums = { 1, 2, 3, 4, 5 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseLinkedListII.reverseBetween(head, 1, 5);
		System.out.println("Reversed: " + CollectionUtilTest.toList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 5, 4, 3, 2, 1 }, reverseHead);
	}

	@Test
	public void testcase4() {
		int[] nums = { 1, 2, 3 };
		ListNode head = CollectionUtil.createLinkedList(nums);
		ListNode reverseHead = reverseLinkedListII.reverseBetween(head, 1, 3);
		System.out.println("Reversed: " + CollectionUtilTest.toList(reverseHead));
		CollectionUtilTest.assertLinkedList(new int[] { 3, 2, 1 }, reverseHead);
	}
}
