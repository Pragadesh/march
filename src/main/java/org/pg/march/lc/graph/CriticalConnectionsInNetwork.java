package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/critical-connections-in-a-network/
 */
public class CriticalConnectionsInNetwork {

	List<List<Integer>> criticalConnections = new ArrayList<>();
	private int time = 0;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

		Graph graph = new Graph(n);
		for (List<Integer> connection : connections) {
			graph.addEdge(connection.get(0), connection.get(1));
		}
		boolean[] visited = new boolean[n];
		Integer[] parent = new Integer[n];
		int[] disc = new int[n];
		int[] low = new int[n];

		for (int v = 0; v < n; v++) {
			if (!visited[v]) {
				dfs(graph, v, visited, parent, disc, low);
			}
		}
		return criticalConnections;
	}

	private void dfs(Graph graph, int v, boolean[] visited, Integer[] parent, int[] disc, int[] low) {
		visited[v] = true;
		disc[v] = low[v] = time++;
		for (int adj : graph.getAdj(v)) {
			if (!visited[adj]) {
				parent[adj] = v;
				dfs(graph, adj, visited, parent, disc, low);
				low[v] = Math.min(low[v], low[adj]);
				if (low[adj] > disc[v]) {
					List<Integer> conn = new ArrayList<>();
					conn.add(v);
					conn.add(adj);
					criticalConnections.add(conn);
				}
				
			} else if(parent[v] != null && adj != parent[v]){
				low[v] = Math.min(low[v], disc[adj]);
			}
		}
	}

	private static class Graph {

		private int V;
		List<Integer>[] adj;

		public Graph(int V) {
			this.V = V;
			adj = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				adj[i] = new LinkedList<>();
			}
		}

		public void addEdge(int u, int v) {
			adj[u].add(v);
			adj[v].add(u);
		}

		public List<Integer> getAdj(int v) {
			return adj[v];
		}

	}
}
