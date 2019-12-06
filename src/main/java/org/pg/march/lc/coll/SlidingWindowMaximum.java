package org.pg.march.lc.coll;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    
    
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0)
            return new int[0];
        if (k == 1)
            return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
    
    
    public int[] maxSlidingWindowWithPQ(int[] nums, int k) {
        if(nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> (b-a));
        Map<Integer, Integer> lazyDeletionMap = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            maxPQ.add(nums[i]);
        }
        result[0] = maxPQ.peek();
        for (int i = k; i < nums.length; i++) {
            int toDel = nums[i - k];
            int toAdd = nums[i];
            if (toDel != toAdd) {
                maxPQ.add(toAdd);
                lazyDeletionMap.put(toDel, lazyDeletionMap.getOrDefault(toDel, 0) + 1);
                while (lazyDeletionMap.containsKey(maxPQ.peek())) {
                    Integer peek = maxPQ.peek();
                    Integer lazyDeleteCount = lazyDeletionMap.get(peek);
                    if (lazyDeleteCount > 0) {
                        lazyDeletionMap.put(peek, --lazyDeleteCount);
                        maxPQ.poll();
                    }
                    if (lazyDeleteCount == 0) {
                        lazyDeletionMap.remove(peek);
                    }
                }
            }
            result[i - k + 1] = maxPQ.peek();
        }

        return result;
    }

}
