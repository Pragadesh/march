package org.pg.march.lc.coll;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val).append(",\tLeft = ").append(left == null ? null : left.val).append(",\tRight = ").append(right == null ? null : right.val);
        return builder.toString();
    }
}
