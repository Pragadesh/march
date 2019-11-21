package org.pg.march.lc.real;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        return 0;
    }
    
    public int trapWithDP(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int traps = 0;
        int[] leftTallest = new int[height.length];
        int[] rightTallest = new int[height.length];

        int N = height.length;
        leftTallest[0] = height[0];
        rightTallest[N-1] = height[N-1];
        for (int i = 1; i < N; i++) {
            leftTallest[i] = Math.max(leftTallest[i - 1], height[i]);
            rightTallest[N - i - 1] = Math.max(rightTallest[N - i], height[N - i - 1]);
        }

        for (int i = 0; i < height.length; i++) {
            traps += Math.min(leftTallest[i], rightTallest[i]) - height[i];
        }
        return traps;
    }
}
