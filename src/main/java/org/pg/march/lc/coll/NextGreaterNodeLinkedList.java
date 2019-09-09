package org.pg.march.lc.coll;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        List<NodeState> largeNodes = new ArrayList<>();
        int index = 0;
        while (head != null) {
            int val = head.val;
            largeNodes.add(new NodeState(val));
            int backwardIndex = index;
            while (--backwardIndex >= 0 && largeNodes.get(backwardIndex).nextLarge < val) {
                NodeState backwardNode = largeNodes.get(backwardIndex);
                if (!backwardNode.found) {
                    backwardNode.nextLarge = val;
                    backwardNode.found = true;
                }
            }
            head = head.next;
            index++;
        }
        int[] largeArr = new int[largeNodes.size()];
        int idx = 0;
        for (NodeState nodeState : largeNodes) {
            largeArr[idx++] = nodeState.found ? nodeState.nextLarge : 0;
        }
        return largeArr;
    }

    private static class NodeState {
        int nextLarge;
        boolean found;

        public NodeState(int val) {
            this.nextLarge = val;
            this.found = false;
        }
    }
}
