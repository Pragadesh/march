package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node();
        dummy.child = head;
        insertChildNodes(dummy);
        return dummy.next;
    }

    public Node insertChildNodes(Node parent) {
        Node endNode = parent.next;
        parent.next = parent.child;
        Node index = parent.next;
        parent.child = null;
        Node prevNode = parent;
        while (index != null) {
            prevNode = index;
            if (index.child != null) {
                index.child.prev = index;
                index = insertChildNodes(index);
            } else {
                index = index.next;
            }
        }
        prevNode.next = endNode;
        if (endNode != null) {
            endNode.prev = prevNode;
        }

        return endNode == null ? prevNode : endNode;
    }
}
