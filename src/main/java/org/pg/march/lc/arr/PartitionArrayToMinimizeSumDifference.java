package org.pg.march.lc.arr;

import java.util.Arrays;

/**
 * https://leetcode.com/contest/weekly-contest-262/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 */
public class PartitionArrayToMinimizeSumDifference {

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 2) return Math.abs(nums[1] - nums[0]);
        int[][] lists1 = generateOriginal(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] lists2 = generateOriginal(Arrays.copyOfRange(nums, n / 2, n));
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= n / 2; d++) {
            int[] arr1 = lists1[d], arr2 = lists2[d];
            int k = arr1.length;
            int i1 = 0, i2 = 0; // we use two pointers to find two elements in arr1, arr2 with minimum absolute difference
            while (i1 < k && i2 < k) {
                int diff = arr1[i1] - arr2[i2];
                ans = Math.min(ans, Math.abs(diff));
                if (diff <= 0) i1++;
                if (diff >= 0) i2++;
            }
        }
        return ans;
    }

    protected int[][] generate(int[] nums) {
        int n = nums.length;
        int ansSize = 1 << n;

        int total = 0;
        for (int num : nums) total += num;

        for (int i = 0; i < n; i++) nums[i] <<= 1;
        int[] sums = new int[ansSize];
        sums[0] -= total;
        for (int i = 0, maxTo = 1; i < n; i++, maxTo <<= 1) {
            int num = nums[i];
            for (int from = 0, to = maxTo; from < maxTo; from++, to++) sums[to] = sums[from] + num;
        }

        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];
        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial];
            binomial = binomial * (n - i) / (i + 1);
        }
        for (int key = 0; key < ansSize; key++) {
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sums[key];
        }
        for (int[] arr : ans) Arrays.sort(arr);
        return ans;
    }

    protected int[][] generateOriginal(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;
        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];
        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial]; // number of ways to choose i from n = binomial(i,n)
            binomial = binomial * (n - i) / (i + 1);
        }
        int maxValue = 1 << n;
        for (int key = 0; key < maxValue; key++) {
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                if ((key >> i & 1) == 1) sum1 += nums[i];
            }
            int sum2 = total - sum1;
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = (2 * sum1) - total;
        }
        for (int[] arr : ans) Arrays.sort(arr);
        return ans;
    }
}
