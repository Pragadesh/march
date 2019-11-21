package org.pg.march.lc.graph;

/*
 * https://leetcode.com/problems/redundant-connection-ii/
 */
public class RedundantConnectionDirected {


    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] e1 = null;
        int[] e2 = null;
        int[] parents = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            if (parents[edges[i][1]] > 0) {
                e1 = new int[] { parents[edges[i][1]], edges[i][1] };
                e2 = new int[] { edges[i][0], edges[i][1] };
                edges[i][0] = 0;
            } else {
                parents[edges[i][1]] = edges[i][0];
            }
        }

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == 0) {
                continue;
            }
            if (root(parents, edges[i][0]) == edges[i][1]) {
                if (e1 == null) {
                    return edges[i];
                } else {
                    return e1;
                }
            }else {
                parents[edges[i][1]] = edges[i][0];
            }
        }
        return e2;
    }

    private int root(int[] parents, int p) {
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }
}
