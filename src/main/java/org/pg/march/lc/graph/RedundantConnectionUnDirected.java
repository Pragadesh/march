package org.pg.march.lc.graph;

/*
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnectionUnDirected {

    int[] parent;
    int[] size;

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] cycleEdge = null;
        parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        size = new int[edges.length + 1];

        for (int[] edge : edges) {
            if (connected(edge[0], edge[1])) {
                cycleEdge = edge;
            }
            union(edge[0], edge[1]);
        }
        return cycleEdge;
    }

    private int root(int v) {
        while (v != parent[v]) {
            v = parent[v];
        }
        return v;
    }

    private void union(int u, int v) {
        int p = root(u);
        int q = root(v);
        if (size[p] < size[q]) {
            parent[p] = parent[q];
            size[q] += size[p];
        } else {
            parent[q] = parent[p];
            size[p] += size[q];
        }
    }

    private boolean connected(int u, int v) {
        return (root(u) == root(v));
    }

    public int[] findRedundantConnection1(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        boolean[] marked = new boolean[edges.length + 1];
        int[] cycleEdge = null;

        for (int[] edge : edges) {
            if (marked[edge[0]] && marked[edge[1]]) {
                cycleEdge = edge;
            }
            marked[edge[0]] = true;
            marked[edge[1]] = true;
        }

        return cycleEdge;
    }
}
