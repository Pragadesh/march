package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/falling-squares/
 */
public class FallingSquares {

	public List<Integer> fallingSquares(int[][] positions) {
		List<Integer> squares = new ArrayList<>();
		Map<Integer, Integer> indexMap = compactIndex(positions);
		int maxHeight = 0;
		SegmentTree tree = new SegmentTree(indexMap.size());
		for (int[] position : positions) {
			int L = indexMap.get(position[0]);
			int R = indexMap.get(position[0] + position[1] - 1);
			int h = tree.query(L, R) + position[1];
			maxHeight = Math.max(maxHeight, h);
			squares.add(maxHeight);
			tree.update(L, R, h);
		}
		return squares;
	}

	private Map<Integer, Integer> compactIndex(int[][] positions) {
		Set<Integer> indexes = new HashSet<>();
		for (int[] position : positions) {
			indexes.add(position[0]);
			indexes.add(position[0] + position[1] - 1);
		}
		List<Integer> sortIndex = new ArrayList<>(indexes);
		Collections.sort(sortIndex);
		Map<Integer, Integer> indexMap = new HashMap<>();
		int i = 0;
		for (Integer index : sortIndex) {
			indexMap.put(index, i++);
		}
		return indexMap;
	}

	private static class SegmentTree {

		private int N;
		private int[] tree;
		private int[] lazy;

		public SegmentTree(int N) {
			this.N = N;
			int n = 1 << (int) (Math.ceil(Math.log(N) / Math.log(2)) + 1);
			tree = new int[n];
			lazy = new int[n];
		}

		public int query(int L, int R) {
			return query(1, 0, N - 1, L, R);
		}

		public void update(int L, int R, int h) {
			update(1, 0, N - 1, L, R, h);
		}

		private void update(int index, int nStart, int nEnd, int L, int R, int h) {
			populateLazyValue(index, nStart, nEnd);
			if (nStart > nEnd || nStart > R || nEnd < L) {
				return;
			}

			if (nStart >= L && nEnd <= R) {
				tree[index] = Math.max(tree[index], h);
				if(nStart != nEnd) {
					lazy[2 * index] = Math.max(lazy[2 * index], h);
					lazy[2 * index + 1] = Math.max(lazy[2 * index + 1], h);
				}
				return;
			}
			int mid = nStart + (nEnd - nStart) / 2;
			update(2 * index, nStart, mid, L, R, h);
			update(2 * index + 1, mid + 1, nEnd, L, R, h);
			tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
		}

		private void populateLazyValue(int index, int nStart, int nEnd) {
			if (lazy[index] > 0) {
				int update = lazy[index];
				tree[index] = Math.max(tree[index], update);
				lazy[index] = 0;
				if (nStart != nEnd) {
					lazy[2 * index] = Math.max(lazy[2 * index], update);
					lazy[2 * index + 1] = Math.max(lazy[2 * index + 1], update);
				}
			}
		}

		private int query(int index, int nStart, int nEnd, int L, int R) {
			populateLazyValue(index, nStart, nEnd);
			if (nStart > nEnd || nStart > R || nEnd < L) {
				return 0;
			}
			if (nStart >= L && nEnd <= R) {
				return tree[index];
			}
			int mid = nStart + (nEnd - nStart) / 2;
			return Math.max(query(2 * index, nStart, mid, L, R), query(2 * index + 1, mid + 1, nEnd, L, R));
		}

	}
}
