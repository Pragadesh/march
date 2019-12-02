package org.pg.march.lc.coll;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinderWithTree {

	private Tree tree;
	
	/** initialize your data structure here. */
	public MedianFinderWithTree() {
		tree = new Tree();
	}

	public void addNum(int num) {
		tree.put(num);
	}

	public double findMedian() {
		return tree.getMedian();
	}
	
	
	
	private static class Tree {
		private Node root;
		
		public void put(int val) {
			this.root = _put(root, val);
			rotateForMedian();
		}
		
		public double getMedian() {
			if(root == null) {
				return 0d;
			}
			int medianPos = (root.size + 1) / 2;
			if(medianPos <= size(root.left) || medianPos > size(root.left) + root.count) {
				throw new IllegalStateException("Invalid median state");
			}
			double median = root.val;
			if(root.size % 2 == 0) {
				medianPos++;
				if(medianPos > size(root.left) + root.count) {
					median += findMinNode(root.right).val;
					median /= 2;
				}
			}
			return median;
		}
		
		private void rotateForMedian() {
			if(root == null) {
				return;
			}
			while((root.size + 1) / 2 > size(root.left) + root.count) {
				Node rightMin = findMinNode(root.right);
				root.right = deleteMinNode(root.right);
				rightMin.left = root;
				rightMin.right = root.right;
				root.right = null;
				root.size = size(root.left) + root.count;
				rightMin.size = size(rightMin.left) + size(rightMin.right) + rightMin.count;
				root = rightMin;
			}
			while((root.size + 1) / 2 <= size(root.left)) {
				Node leftMax = findMaxNode(root.left);
				root.left = deleteMaxNode(root.left);
				leftMax.right = root;
				leftMax.left = root.left;
				root.left = null;
				root.size = size(root.right) + root.count;
				leftMax.size = size(leftMax.left) + size(leftMax.right) + leftMax.count;
				root = leftMax;
			}
		}
		
		private Node _put(Node node, int val) {
			if(node == null) {
				return new Node(val);
			}
			System.out.println("Put in node: " + node);
			int compare = Integer.compare(val, node.val);
			if(compare < 0) {
				node.left = _put(node.left, val);
			}else if(compare > 0) {
				node.right = _put(node.right, val);
			}else {
				node.count++;
			}
			node.size = size(node.left) + size(node.right) + node.count;
			return node;
		}
		
		private Node findMinNode(Node node) {
			if (node == null) {
				return node;
			}
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
		
		private Node findMaxNode(Node node) {
			if (node == null) {
				return node;
			}
			while (node.right != null) {
				node = node.right;
			}
			return node;
		}
		
		private Node deleteMinNode(Node node) {
			if(node == null) {
				return node;
			}
			if(node.left == null) {
				return node.right;
			}
			node.left = deleteMinNode(node.left);
			node.size = size(node.left) + size(node.right) + node.count;
			return node;
		}
		
		private Node deleteMaxNode(Node node) {
			if(node == null) {
				return node;
			}
			if(node.right == null) {
				return node.left;
			}
			node.right = deleteMaxNode(node.right);
			node.size = size(node.left) + size(node.right) + node.count;
			return node;
		}
		
		private int size(Node node) {
			return node == null ? 0 : node.size;
		}
		
	}
	
	
	
	private static class Node {
		private int val;

		private Node left;
		private Node right;

		private int size;
		private int count;

		public Node(int val) {
			this.val = val;
			this.count = 1;
			this.size = 1;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", size=" + size + ", count=" + count + "]";
		}
		
	}
}
