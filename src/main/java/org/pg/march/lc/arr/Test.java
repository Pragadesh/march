package org.pg.march.lc.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test {

    public int equalSubstring(String s, String t, int maxCost) {
        int k = 0;
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
            maxCost -= cost[i];
            if(maxCost < 0) {
                maxCost += cost[k++];
            }
        }
        return (t.length() - k);
    }

    public int equalSubstringPrev(String s, String t, int maxCost) {
        if (s == null || t == null || s.length() == 0 || s.length() != t.length()) {
            return 0;
        }
        int[] cost = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        List<Entry<Integer, Integer>> lengthCostSeqs = new LinkedList<>();
        List<Entry<Integer, Integer>> temp = new LinkedList<>();
        int maxLength = 0;

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] <= maxCost) {
                temp.add(new Entry<>(1, cost[i]));
                maxLength = Math.max(maxLength, 1);
            }
            for (Entry<Integer, Integer> lengthCost : lengthCostSeqs) {
                if (lengthCost.getValue() + cost[i] <= maxCost) {
                    temp.add(new Entry<>(lengthCost.getKey() + 1, lengthCost.getValue() + cost[i]));
                    maxLength = Math.max(maxLength, lengthCost.getKey() + 1);
                }
            }
            System.out.println(temp);
            lengthCostSeqs.clear();
            lengthCostSeqs.addAll(temp);
            temp.clear();
        }

        return maxLength;

    }

    private static class Entry<K, V> {
        private K k;
        private V v;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        @Override
        public String toString() {
            return String.format("[%d,%d]", k, v);
        }
    }

    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        Arrays.sort(arr);

        int num = arr[0];
        int count = 1;
        Set<Integer> uniqueCounts = new HashSet<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            } else {
                if (uniqueCounts.contains(count)) {
                    return false;
                }
                uniqueCounts.add(count);
                num = arr[i];
                count = 1;
            }

        }
        return uniqueCounts.contains(count);
    }


    public static void main(String[] args) {
        Test t = new Test();
         System.out.println(t.equalSubstring("abcd", "bcdf", 3));
         System.out.println(t.equalSubstring("abcd", "cdef", 3));
         System.out.println(t.equalSubstring("abcd", "acde", 0));
         System.out.println(t.equalSubstring("abc", "xyz", 3));

    }
}
