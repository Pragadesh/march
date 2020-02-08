package org.pg.march.lc.graph;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/bricks-falling-when-hit/
 */
public class BricksFallingWhenHit {

	private int R;
	private int C;
	private static final int[][] moves = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
	private static final int TOP_ROW = 0;

	public int[] hitBricks(int[][] grid, int[][] hits) {
		this.R = grid.length;
		this.C = grid[0].length;
		Graph graph = constuctGraph(grid);
		int[] res = new int[hits.length];
		for (int i = 0; i < hits.length; i++) {
			int[] hit = hits[i];
			if (grid[hit[0]][hit[1]] == 1) {
				res[i] = findBricksFell(grid, graph, hit[0] * C + hit[1]) - 1;
			}
		}
		return res;
	}

	private int findBricksFell(int[][] grid, Graph graph, int v) {
		int fell = 1;
		for (int child : graph.children[v]) {
			graph.parents[child].remove(v);
			if (graph.parents[child].isEmpty()) {
				fell += findBricksFell(grid, graph, child);
			}
		}
		grid[v / C][v % C] = 0;
		graph.children[v].clear();
		return fell;
	}

	private Graph constuctGraph(int[][] grid) {
		Graph graph = new Graph(R * C);
		boolean[] visited = new boolean[R * C];
		for (int i = 0; i < C; i++) {
			if (grid[TOP_ROW][i] == 1) {
				createGraphDFS(grid, graph, i, visited);
			}
		}
		return graph;
	}

	private void createGraphDFS(int[][] grid, Graph graph, int v, boolean[] visited) {
		visited[v] = true;
		int r = v / C;
		int c = v % C;
		for (int[] move : moves) {
			int dr = r + move[0];
			int dc = c + move[1];
			int child = dr * C + dc;
			if (dr >= 0 && dc >= 0 && dr < R && dc < C && dr != TOP_ROW && grid[dr][dc] == 1 && !visited[child]) {
				graph.addEdge(v, child);
				if (r != TOP_ROW)
					graph.addEdge(child, v);
				createGraphDFS(grid, graph, child, visited);
			}
		}
	}

	private static class Graph {

		final int V;
		final Set<Integer>[] children;
		final Set<Integer>[] parents;

		public Graph(int V) {
			this.V = V;
			this.children = new Set[V];
			this.parents = new Set[V];
			for (int i = 0; i < V; i++) {
				this.children[i] = new HashSet<>();
				this.parents[i] = new HashSet<>();
			}
		}

		public void addEdge(int p, int c) {
			this.children[p].add(c);
			this.parents[c].add(p);
		}
	}
}
