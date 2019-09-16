package org.pg.march.lc.coll;

public class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;

	public Node() {
	}

	public Node(int _val) {
		this.val = _val;
	}

	public Node(int _val, Node _prev, Node _next, Node _child) {
		val = _val;
		prev = _prev;
		next = _next;
		child = _child;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(val).append("\n");
		builder.append("Left: ").append(prev == null ? null : prev.val).append("\t").append("Right: ")
				.append(next == null ? null : next.val).append("\n");
		builder.append("Child: ").append(child == null ? null : child.val);
		return builder.toString();
	}
}
