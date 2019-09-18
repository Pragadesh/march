package org.pg.march.lc.tree;

/*
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] treeCount = new int[n + 1];
        treeCount[0] = 1;
        treeCount[1] = 1;

        for (int i = 2; i < treeCount.length; i++) {
            int count = 0;
            int index = 0;
            while (index < (i / 2)) {
                count += 2 * (treeCount[index] * treeCount[i - index - 1]);
                index++;
            }
            if (i % 2 == 1) {
                count += (treeCount[(i / 2)] * treeCount[(i / 2)]);
            }
            treeCount[i] = count;
        }

        return treeCount[n];
    }
    
    public int numTreesInSolution(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
