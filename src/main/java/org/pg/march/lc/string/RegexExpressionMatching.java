package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegexExpressionMatching {

    public static void main(String[] args){
        isMatchBottomUpDP("aab", "a*b");
    }
    
    public static boolean isMatchBottomUpDP(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
    
	public boolean isMatch(String s, String p) {
		return false;
	}
	public boolean isMatchByRecursion(String s, String p) {
		if(p.isEmpty()){
			return s.isEmpty();
		}
		boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		if(p.length() >= 2 && p.charAt(1) == '*'){
			return (isMatchByRecursion(s, p.substring(2)) || (firstMatch && isMatchByRecursion(s.substring(1), p)));
		}else{
			return firstMatch && isMatchByRecursion(s.substring(1), p.substring(1));
		}
	}
	
	public boolean isMatchByNFA(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if(s.isEmpty() && p.isEmpty()){
			return true;
		}
		Graph transitionGraph = createTransitionGraph(p);
		char[] pattern = p.toCharArray();
		List<Integer> validStates = new ArrayList<>();
		DFS dfs = new DFS(transitionGraph, 0);
		for (int v = 0; v < transitionGraph.V(); v++) {
			if (dfs.marked[v])
				validStates.add(v);
		}

		for (int i = 0; i < s.length(); i++) {
			List<Integer> matchStates = new ArrayList<>();
			for (int v : validStates) {
				if (v == pattern.length) {
					continue;
				}
				if (pattern[v] == s.charAt(i) || pattern[v] == '.') {
					matchStates.add(v + 1);
				}
			}
			validStates = new ArrayList<>();
			dfs = new DFS(transitionGraph, matchStates);
			for (int v = 0; v < transitionGraph.V(); v++) {
				if (dfs.marked[v])
					validStates.add(v);
			}
		}

		for (int i : validStates) {
			if (i == pattern.length) {
				return true;
			}
		}

		return false;
	}

	private Graph createTransitionGraph(String p) {
		char[] pattern = p.toCharArray();
		int patternLength = pattern.length;
		Graph g = new Graph(patternLength + 1);
		for (int i = 0; i < patternLength; i++) {
			if (i < patternLength - 1 && pattern[i + 1] == '*') {
				g.addEdge(i, i + 1);
				g.addEdge(i + 1, i);
			}
			if (pattern[i] == '*') {
				g.addEdge(i, i + 1);
			}
		}
		return g;
	}

	private static class DFS {

		private boolean[] marked;

		public DFS(Graph g, int v) {
			this.marked = new boolean[g.V()];
			dfs(g, v);
		}

		public DFS(Graph g, List<Integer> vertices) {
			this.marked = new boolean[g.V()];
			for (int v : vertices) {
				if (!marked[v]) {
					dfs(g, v);
				}
			}
		}

		private void dfs(Graph g, int v) {
			this.marked[v] = true;
			for (int i : g.adj(v)) {
				if (!marked[i]) {
					dfs(g, i);
				}
			}
		}

		private boolean marked(int v) {
			return marked(v);
		}
	}

	private static class Graph {
		private int V;
		private List<Integer>[] edges;

		public Graph(int V) {
			this.V = V;
			this.edges = (List<Integer>[]) new List[V];
			for (int i = 0; i < V; i++) {
				this.edges[i] = new ArrayList<Integer>();
			}
		}

		public void addEdge(int v, int w) {
			this.edges[v].add(w);
		}

		public int V() {
			return V;
		}

		public List<Integer> adj(int v) {
			return this.edges[v];
		}
	}
}
