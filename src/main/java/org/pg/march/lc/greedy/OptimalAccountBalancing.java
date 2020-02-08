package org.pg.march.lc.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/optimal-account-balancing/
 */
public class OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> accountBalanceMap = new HashMap<Integer, Integer>();
        for (int[] transaction : transactions) {
            accountBalanceMap.put(transaction[0], accountBalanceMap.getOrDefault(transaction[0], 0) + transaction[2]);
            accountBalanceMap.put(transaction[1], accountBalanceMap.getOrDefault(transaction[1], 0) - transaction[2]);
        }
        return findMinTransaction(0, new ArrayList<>(accountBalanceMap.values()));
    }

    private int findMinTransaction(int start, List<Integer> balanceSheet) {
        while (start < balanceSheet.size() && balanceSheet.get(start) == 0) {
            start++;
        }
        if (start == balanceSheet.size())
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < balanceSheet.size(); i++) {
            if (balanceSheet.get(start) * balanceSheet.get(i) < 0) {
                balanceSheet.set(i, balanceSheet.get(i) + balanceSheet.get(start));
                res = Math.min(res, 1 + findMinTransaction(start + 1, balanceSheet));
                balanceSheet.set(i, balanceSheet.get(i) - balanceSheet.get(start));
            }
        }
        return res;
    }
}
