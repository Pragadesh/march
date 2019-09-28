package org.pg.march.lc.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/
 */
public class SortByGroupsRespectingDependencies {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        Graph graph = new Graph(n);

        for (int i = 0; i < beforeItems.size(); i++) {
            for (Integer before : beforeItems.get(i)) {
                graph.addEdge(i, before);
            }
        }
        TopologySort topology = new TopologySort(graph);
        Iterable<Integer> items = topology.sort();
        if(items == null) {
            return new int[] {};
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (Integer item : items) {
            int g = group[item];
            if (g >= 0) {
                groups.putIfAbsent(g, new ArrayList<>());
                groups.get(g).add(item);
            }

        }
        int i = 0;
        int[] result = new int[n];
        for (Integer item : items) {
            if (group[item] < 0) {
                result[i++] = item;
            } else if (groups.containsKey(group[item])) {
                for (Integer gItem : groups.remove(group[item])) {
                    result[i++] = gItem;
                }

            }
        }
        for (List<Integer> grps : groups.values()) {
            for (Integer gItem : grps) {
                result[i++] = gItem;
            }
        }

        return result;
    }

    private static class TopologySort {

        private boolean[] marked;
        private boolean[] visited;
        private Graph graph;

        public TopologySort(Graph graph) {
            this.graph = graph;
            marked = new boolean[graph.V()];
            visited = new boolean[graph.V()];
        }

        public Iterable<Integer> sort() {
            try {
                LinkedList<Integer> result = new LinkedList<>();
                for (int v = 0; v < graph.V(); v++) {
                    if (!marked[v]) {
                        dfs(v, result);
                    }
                }
                return result;
            } catch (IllegalStateException e) {
                return null;
            }

        }

        public void dfs(int v, LinkedList<Integer> result) {
            marked[v] = true;
            visited[v] = true;
            for (Integer adj : graph.adj(v)) {
                if (visited[adj]) {
                    throw new IllegalStateException("Cycle detected");
                }
                if (!marked[adj]) {
                    dfs(adj, result);
                }
            }
            result.addLast(v);
            visited[v] = false;
        }
    }

    private static class Graph {

        private int V;
        private Set<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            adj = new Set[V];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new HashSet<>();
            }
        }

        public int V() {
            return V;
        }

        public void addEdge(int to, int from) {
            adj[to].add(from);
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }
}
