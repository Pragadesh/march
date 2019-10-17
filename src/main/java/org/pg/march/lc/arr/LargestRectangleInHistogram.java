package org.pg.march.lc.arr;

import java.util.Stack;

/*
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            Pair pair = null;
            while(!stack.isEmpty() && stack.peek().height > heights[i]) {
                pair = stack.pop();
                maxArea = Math.max(maxArea, pair.height * (i - pair.index));
            }
            stack.push(new Pair(pair == null? i : pair.index, heights[i]));
        }
        while(!stack.isEmpty()) {
            Pair pair = stack.pop();
            maxArea = Math.max(maxArea, pair.height * (heights.length - pair.index));
        }
        return maxArea;
    }
    
    private static class Pair{
        private int index;
        private int height;
        
        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
        
        @Override
        public String toString() {
            return "Pair [index=" + index + ", height=" + height + "]";
        }
    }
}
