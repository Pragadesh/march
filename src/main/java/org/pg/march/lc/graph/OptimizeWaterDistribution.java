package org.pg.march.lc.graph;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 */
public class OptimizeWaterDistribution {

	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
			return Integer.compare(a[2], b[2]);
		});
		for (int i = 0; i < wells.length; i++) {
			pq.offer(new int[] { i + 1, 0, wells[i] });
		}
		for(int[] pipe : pipes) {
			pq.offer(pipe);
		}
		int cost = 0;
		UnionFind uf = new UnionFind(n + 1);
		while(!pq.isEmpty()) {
			int[] edge = pq.poll();
			if(!uf.isConnected(edge[0], edge[1])) {
				cost += edge[2];
				uf.union(edge[0], edge[1]);
			}
			
		}
		return cost;
	}

	private static class UnionFind {

		int[] parent;

		public UnionFind(int N) {
			parent = new int[N];
			for (int i = 0; i < N; i++) {
				parent[i] = i;
			}
		}

		private int root(int n) {
			while (n != parent[n]) {
				n = parent[n];
			}
			return n;
		}

		public boolean isConnected(int n1, int n2) {
			return (root(n1) == root(n2));
		}

		public void union(int n1, int n2) {
			int r1 = root(n1);
			int r2 = root(n2);
			parent[r1] = r2;
		}
	}
}
