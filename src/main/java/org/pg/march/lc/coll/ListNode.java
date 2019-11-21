package org.pg.march.lc.coll;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val).append(" -> ").append(next == null ? null : next.val);
        return builder.toString();
    }
}
