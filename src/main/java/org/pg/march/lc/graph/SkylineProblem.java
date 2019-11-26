package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class SkylineProblem {

	public List<List<Integer>> getSkyline(int[][] buildings) {
		PriorityQueue<Rectangle> pQueue = initPriorityQueue(buildings);
		BinaryTraverser binaryTraverser = new BinaryTraverser();
		List<List<Integer>> skyline = new ArrayList<>();
		int currHeight = 0;
		while (!pQueue.isEmpty()) {
			Rectangle rectangle = pQueue.poll();
			if (rectangle.reverse) {
				binaryTraverser.delete(rectangle.end, rectangle.start, rectangle.height);
			} else {
				binaryTraverser.insert(rectangle.start, rectangle.end, rectangle.height);
			}
			int newHeight = binaryTraverser.getMaxHeight();
			int x = getX(rectangle);
			if (newHeight != currHeight && (pQueue.isEmpty() || getX(pQueue.peek()) != x)) {
				skyline.add(createPoint(x, newHeight));
				currHeight = newHeight;
			}
			
		}
		return skyline;
	}

	private int getX(Rectangle rectangle) {
		return rectangle.start;
	}
	
	private List<Integer> createPoint(int x, int height) {
		List<Integer> point = new ArrayList<>();
		point.add(x);
		point.add(height);
		return point;
	}

	private PriorityQueue<Rectangle> initPriorityQueue(int[][] buildings) {
		PriorityQueue<Rectangle> pQueue = new PriorityQueue<>();
		for (int[] building : buildings) {
			pQueue.add(new Rectangle(building[0], building[1], building[2], false));
			pQueue.add(new Rectangle(building[1], building[0], building[2], true));
		}
		return pQueue;
	}

	private static class BinaryTraverser {

		private BinaryTraverserNode root;

		public int getMaxHeight() {
			return root == null ? 0 : root.maxHeight;
		}

		public void insert(int start, int end, int height) {
			this.root = insert(root, start, end, height);
		}

		public void delete(int start, int end, int height) {
			this.root = delete(root, start, end, height);
		}

		private BinaryTraverserNode insert(BinaryTraverserNode node, int start, int end, int height) {
			if (node == null) {
				return new BinaryTraverserNode(start, end, height);
			}
			int compare = Integer.compare(end, node.key);
			if (compare == 0) {
				node.add(start, height);
			} else if (compare < 0) {
				node.left = insert(node.left, start, end, height);
			} else {
				node.right = insert(node.right, start, end, height);
			}
			node.maxHeight = calculateMaxHeight(node);
			return node;
		}

		private BinaryTraverserNode delete(BinaryTraverserNode node, int start, int end, int height) {
			if (node == null) {
				return null;
			}
			int compare = Integer.compare(end, node.key);
			if (compare == 0) {
				node.remove(start, height);
				if (node.isEmpty()) {
					if (node.left == null) {
						return node.right;
					} else if (node.right == null) {
						return node.left;
					} else {
						BinaryTraverserNode rightMin = findMin(node.right);
						deleteMin(node.right);
						rightMin.left = node.left;
						rightMin.right = node.right;
					}
				}
			} else if (compare < 0) {
				node.left = delete(node.left, start, end, height);
			} else {
				node.right = delete(node.right, start, end, height);
			}
			node.maxHeight = calculateMaxHeight(node);
			return node;
		}

		private BinaryTraverserNode deleteMin(BinaryTraverserNode node) {
			if (node == null || node.left == null) {
				return null;
			}
			node.left = deleteMin(node.left);
			node.maxHeight = Math.max(maxHeight(node.left), maxHeight(node.right));
			return node;
		}

		private BinaryTraverserNode findMin(BinaryTraverserNode node) {
			if (node == null || node.left == null) {
				return node;
			}
			return findMin(node.left);
		}

		private int maxHeight(BinaryTraverserNode node) {
			return node == null ? 0 : node.maxHeight;
		}

		private int calculateMaxHeight(BinaryTraverserNode node) {
			return Math.max(node.nodeMaxHeight, Math.max(maxHeight(node.left), maxHeight(node.right)));
		}
	}

	private static class BinaryTraverserNode {
		private int key;
		private int nodeMaxHeight;
		private int maxHeight;
		private Map<Integer, Integer> startHeightMap;

		private BinaryTraverserNode left;
		private BinaryTraverserNode right;

		public BinaryTraverserNode(int start, int end, int height) {
			this.key = end;
			this.nodeMaxHeight = height;
			this.maxHeight = height;
			this.startHeightMap = new HashMap<>();
			this.startHeightMap.put(start, height);
		}

		public void remove(int start, int height) {
			Integer currHeight = startHeightMap.get(start);
			if (currHeight == null || currHeight < height) {
				throw new IllegalStateException(
						String.format("Max height %d is less than the expected height %d", currHeight, height));
			}
			startHeightMap.remove(start);
			if (currHeight >= nodeMaxHeight) {
				for (Integer h : startHeightMap.values()) {
					nodeMaxHeight = Math.max(nodeMaxHeight, h);
				}
			}
		}

		public void add(int start, int height) {
			Integer currHeight = startHeightMap.get(start);
			if (currHeight == null || currHeight < height) {
				startHeightMap.put(start, height);
				nodeMaxHeight = Math.max(nodeMaxHeight, height);
			}
		}

		public boolean isEmpty() {
			return startHeightMap.size() == 0;
		}

		@Override
		public String toString() {
			return "BinaryTraverserNode [key=" + key + ", maxHeight=" + maxHeight + ", startHeightMap=" + startHeightMap
					+ ", left=" + left + ", right=" + right + "]";
		}
	}

	private static class Rectangle implements Comparable<Rectangle> {
		private int start;
		private int end;
		private int height;
		private boolean reverse;

		public Rectangle(int start, int end, int height, boolean reverse) {
			super();
			this.start = start;
			this.end = end;
			this.height = height;
			this.reverse = reverse;
		}

		@Override
		public int compareTo(Rectangle other) {
			int compare = Integer.compare(this.start, other.start);
			if(compare == 0)
				return Integer.compare(this.height, other.height);
			return compare;
		}

		@Override
		public String toString() {
			return "Rectangle [start=" + start + ", end=" + end + ", height=" + height + ", reverse=" + reverse + "]";
		}

	}
}
