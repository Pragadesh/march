package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/redundant-connection-ii/
 */
public class RedundantConnectionDirected {


    public int[] findRedundantDirectedConnection(int[][] edges) {
    	int N = 0;
    	for(int[] edge : edges) {
    		N = Math.max(N, Math.max(edge[0], edge[1]));
    	}
    	N++;
    	Graph graph = new Graph(N);
    	for(int[] edge : edges) {
    		graph.addEdge(edge[0], edge[1]);
    	}
    	int[] parent = new int[N];
    	boolean[] inPath = new boolean[N];
    	boolean[] visited = new boolean[N];
    	
    	for(int i=1; i<=N; i++) {
    		if(!visited[i]) {
    			int[] res = dfs(graph, parent, inPath, visited, i);
        		if(res != null) return res;
    		}
    	}
    	return null;
    }
    
    private int[] dfs(Graph graph, int[] parent, boolean[] inPath, boolean[] visited, int v) {
    	visited[v] = true;
    	inPath[v] = true;
    	for(int adj : graph.adj[v]) {
    		if((parent[adj] > 0 && parent[adj] != v) || inPath[adj]) {
    			return new int[] {v, adj};
    		}
    		parent[adj] = v;
    		if(!visited[adj]) {
    			int[] res = dfs(graph, parent, inPath, visited, adj);
        		if(res != null) return res;
    		}
    	}
    	inPath[v] = false;
    	return null;
    }
    
    private static class Graph {

		final int V;
		final List<Integer>[] adj;

		public Graph(int V) {
			this.V = V;
			this.adj = new List[V];
			for (int i = 0; i < V; i++) {
				this.adj[i] = new ArrayList<>();
			}
		}

		public void addEdge(int v, int w) {
			this.adj[v].add(w);
		}
	}

}
