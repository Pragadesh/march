package org.pg.march.lc.coll;

import org.junit.Before;
import org.junit.Test;
import org.pg.march.util.CollectionUtil;
import org.pg.march.util.CollectionUtilTest;
import org.pg.march.util.TreeUtil;

import junit.framework.Assert;

public class FlattenMultilevelDoublyLinkedListTest {

    private FlattenMultilevelDoublyLinkedList flattenMultilevelDoublyLinkedList;

    @Before
    public void setup() {
        flattenMultilevelDoublyLinkedList = new FlattenMultilevelDoublyLinkedList();
    }

    @Test
    public void testcase1() {
        Node head = CollectionUtil.createDoubleLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });
        Node firstLevelChild = CollectionUtil.createDoubleLinkedList(new int[] { 7, 8, 9, 10 });
        Node secondLevelChild = CollectionUtil.createDoubleLinkedList(new int[] { 11, 12 });
        TreeUtil.addChild(firstLevelChild, secondLevelChild, 2);
        TreeUtil.addChild(head, firstLevelChild, 3);
        Node flatHead = flattenMultilevelDoublyLinkedList.flatten(head);
        CollectionUtilTest.assertDoubleLinkedList(new int[] { 1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6 }, flatHead);
    }

    @Test
    public void testcase2() {
        int N = 500;
        int i = 1;
        Node head = new Node(i);
        Node parent = head;
        int[] result = new int[N];
        result[i - 1] = i;
        while (i++ < N) {
            result[i - 1] = i;
            Node curr = new Node(i);
            parent.child = curr;
            parent = curr;
        }

        Node flatHead = flattenMultilevelDoublyLinkedList.flatten(head);
        CollectionUtilTest.assertDoubleLinkedList(result, flatHead);
    }
}
