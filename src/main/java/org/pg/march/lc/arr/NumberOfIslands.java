package org.pg.march.lc.arr;

/*
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		return -1;
	}
	
	
	
	
	private static class UnionFind{
		private int N;
		private int[] parent;
		private int[] size;
		
		public UnionFind(int N) {
			this.N = N;
			this.parent = new int[N];
			this.size = new int[N];
			for(int i = 0; i<N; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}
		
		private int root(int e) {
			while(e != parent[e]) {
				e = parent[e];
			}
			return e;
		}
		
		public boolean isConnected(int e1, int e2) {
			return root(e1) == root(e2);
		}
		
		public void union(int e1, int e2) {
			int r1 = root(e1);
			int r2 = root(e2);
			if(r1 != r2) {
				parent[r2] = r1;
			}
		}
		
	}
}
