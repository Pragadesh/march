package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;

import junit.framework.Assert;

public class PalindromeLinkedListTest {

    private PalindromeLinkedList palindromeLinkedList;

    @Before
    public void setup() {
        palindromeLinkedList = new PalindromeLinkedList();
    }

    @Test
    public void testcase1() {
        int[] nums = { 1, 2 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        Assert.assertEquals("Palindrome detected", false, palindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void testcase2() {
        int[] nums = { 1, 2, 2, 1 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        Assert.assertEquals("Palindrome detected", true, palindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void testcase3() {
        int[] nums = { 1, 2, 9, 2, 1 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        Assert.assertEquals("Palindrome detected", true, palindromeLinkedList.isPalindrome(head));
    }
    
    @Test
    public void testcase4() {
        int[] nums = { 1, 9, 9, 2, 1 };
        ListNode head = CollectionUtil.createLinkedList(nums);
        Assert.assertEquals("Palindrome detected", false, palindromeLinkedList.isPalindrome(head));
    }
}
