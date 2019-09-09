package org.pg.march.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.pg.march.lc.coll.ListNode;

public class CollectionUtilTest {

    public static void assertLinkedList(int[] nums, ListNode head) {
        if (nums == null || nums.length == 0) {
            Assert.assertNull("No nodes expected", head);
            return;
        }
        Assert.assertNotNull(String.format("Expected length: %d, but found empty", nums.length), head);
        List<Integer> actual = new ArrayList<>();
        while (head != null) {
            actual.add(head.val);
            head = head.next;
        }
        int[] actualArr = new int[actual.size()];
        for (int i = 0; i < actualArr.length; i++) {
            actualArr[i] = actual.get(i);
        }
        Assert.assertArrayEquals("Linked list data validation failed", nums, actualArr);

    }

}
