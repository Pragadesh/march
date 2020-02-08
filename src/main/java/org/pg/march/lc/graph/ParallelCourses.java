package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/parallel-courses
 */
public class ParallelCourses {

	public int minimumSemesters(int N, int[][] relations) {
		
		Graph graph = new Graph(N + 1);
		Graph reverseGraph = new Graph(N + 1);
		for(int[] relation : relations) {
			graph.addAdjacent(relation[1], relation[0]);
			reverseGraph.addAdjacent(relation[0], relation[1]);
		}
		boolean[] visited = new boolean[graph.V];
		boolean[] inPath = new boolean[graph.V];
		List<Integer> traversePath = new ArrayList<>();
		for (int i = 1; i < reverseGraph.V; i++) {
			if(!visited[i]) {
				boolean cycle = detectCycleAndConstructPath(reverseGraph, traversePath, visited, inPath, i);
				if(cycle) return -1;
			}
		}
		visited = new boolean[graph.V];
		int[] depth = new int[graph.V];
		for(Integer v : traversePath) {
			if(!visited[v]) {
				maxDepth(graph, visited,depth, v);
			}
		}
		int max = 0;
		for(int d : depth) {
			max = Math.max(max, d);
		}
		return max;
	}

	private void maxDepth(Graph graph, boolean[] visited, int[] depth, int v) {
		int maxDepth = 1;
		visited[v] = true;
		for(Integer adj : graph.adj[v]) {
			if(!visited[adj]) {
				maxDepth(graph, visited, depth, adj);
			}
			maxDepth = Math.max(maxDepth, depth[adj] + 1);
		}
		depth[v] = maxDepth;
	}
	
	private boolean detectCycleAndConstructPath(Graph graph, List<Integer> traversePath, boolean[] visited, boolean[] inPath, int v) {
		if(inPath[v]) return true;
		visited[v] = true;
		inPath[v] = true;
		
		for(Integer adj : graph.adj[v]) {
			if(inPath[adj]) return true;
			if(!visited[adj]) {
				if(detectCycleAndConstructPath(graph, traversePath, visited, inPath, adj)) {
					return true;
				}
			}
		}
		traversePath.add(v);
		
		inPath[v] = false;
		return false;
	}

	public static class Graph {
		int V;
		List<Integer>[] adj;

		public Graph(int V) {
			this.V = V;
			this.adj = new List[V];
			for (int i = 1; i < V; i++) {
				this.adj[i] = new ArrayList<>();
			}
		}

		public void addAdjacent(int v, int w) {
			this.adj[v].add(w);
		}

		public List<Integer> adj(int v) {
			return this.adj[v];
		}
	}
}
