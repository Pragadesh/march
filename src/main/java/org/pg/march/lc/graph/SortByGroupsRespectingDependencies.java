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

        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        Graph itemGraph = new Graph(n);
        Graph groupGraph = new Graph(m);
        for (int i = 0; i < beforeItems.size(); i++) {
            int igroup = group[i];
            for (Integer before : beforeItems.get(i)) {
                itemGraph.addEdge(i, before);
                if (group[before] != igroup) {
                    groupGraph.addEdge(igroup, group[before]);
                }
            }
        }
        TopologySort itemTopology = new TopologySort(itemGraph);
        Iterable<Integer> items = itemTopology.sort();
        TopologySort groupTopology = new TopologySort(groupGraph);
        Iterable<Integer> groups = groupTopology.sort();
        
        if (items == null || groups == null) {
            return new int[] {};
        }

        Map<Integer, List<Integer>> groupItemMap = new HashMap<>();
        for (Integer item : items) {
            int g = group[item];
            groupItemMap.putIfAbsent(g, new ArrayList<>());
            groupItemMap.get(g).add(item);
        }
        int i = 0;
        int[] result = new int[n];
        for(int g : groups) {
            for (Integer gItem :  groupItemMap.getOrDefault(g, new ArrayList<>())) {
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
