package org.pg.march.lc.string;

import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int len = s.length();
        UnionFind uf = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        CharSorter[] charGroups = new CharSorter[len];
        int[] index = new int[len];

        for (int i = 0; i < len; i++) {
            int p = uf.root(i);
            if(charGroups[p] == null) {
                charGroups[p] = new CharSorter(uf.size(p));
            }
            charGroups[p].values[index[p]++] = s.charAt(i);
            if(index[p] >= charGroups[p].values.length) {
                charGroups[p].sort();
                index[p] = 0;
            }
        }
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            int p = uf.root(i);
            result[i] = charGroups[p].values[index[p]++];
        }
        return String.valueOf(result);
    }

    private static class CharSorter {
        char[] values;

        public CharSorter(int n) {
            values = new char[n];
        }

        public void sort() {
            Arrays.sort(values);
        }
    }

    private static class UnionFind {
        private int[] parent;
        private int[] size;
        private int N;

        public UnionFind(int N) {
            this.N = N;
            parent = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            
        }

        public int root(int p) {
            while (p != parent[p]) {
                p = parent[p];
            }
            return p;
        }
        
        public int size(int p) {
            return size[p];
        }

        private void validate(int i) {
            if (i < 0 || i >= N) {
                throw new IllegalArgumentException("Illegal value: " + i);
            }
        }

        public boolean connected(int p, int q) {
            validate(p);
            validate(q);
            return (root(p) == root(q));
        }

        public void union(int p, int q) {
            validate(p);
            validate(q);
            int rp = root(p);
            int rq = root(q);
            if (rp != rq) {
                if (size[rp] < size[rq]) {
                    parent[rp] = rq;
                    size[rq] += size[rp];
                } else {
                    parent[rq] = rp;
                    size[rp] += size[rq];
                }
            }
        }
    }
}
