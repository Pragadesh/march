package org.pg.march.lc.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {

	public int networkDelayTime(int[][] times, int N, int K) {
		
		int[] distanceTo = new int[N+1];
		int[] fromVertex = new int[N+1];
		boolean[] marked = new boolean[N+1];
		Arrays.fill(distanceTo, -1);
		Graph graph = new Graph(N);
		for(int[] time : times) {
			graph.addEdge(time);
		}
		distanceTo[K] = 0;
		distanceTo[0] = 0;
		dfs(graph, K, distanceTo, fromVertex, marked);
		int max = Integer.MIN_VALUE;
		for(int distance: distanceTo) {
			if(distance == -1) return -1;
			max = Math.max(distance, max);
		}
		return max;
	}
	
	private void dfs(Graph graph, int v, int[] distanceTo, int[] fromVertex, boolean[] marked) {
		marked[v] = true;
		for(int[] time : graph.adj[v]) {
			if(distanceTo[time[1]] == -1 || distanceTo[v] + time[2] < distanceTo[time[1]]) {
				distanceTo[time[1]] = distanceTo[v] + time[2];
				fromVertex[time[1]] = v;
			}
			if(!marked[time[1]]) {
				dfs(graph, time[1], distanceTo, fromVertex, marked);
			}
		}
	}

	private static class Graph {

		private int V;
		private List<int[]>[] adj;

		public Graph(int V) {
			this.V = V;
			this.adj = new List[V + 1];
			for (int i = 0; i <= V; i++) {
				this.adj[i] = new LinkedList<>();
			}
		}
		private void addEdge(int[] time) {
			this.adj[time[0]].add(time);
		}
	}
}
