package org.pg.march.lc.arr;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
 */
public class KthLargestInteger {

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((el1, el2) -> {
            if (el1.length() != el2.length()) {
                return Integer.compare(el1.length(), el2.length());
            }
            return el1.compareTo(el2);
        });
        for (String s : nums) {
            minHeap.offer(s);
            while (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

}
