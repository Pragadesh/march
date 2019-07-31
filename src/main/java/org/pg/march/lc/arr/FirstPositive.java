package org.pg.march.lc.arr;

public class FirstPositive {

    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return N + 1;
    }

    public int firstMissingPositiveOriginal(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] == -1) {
                nums[i] = -2;
            }
        }

        for (int i = 0; i < N; i++) {
            int val = nums[i];
            if (val != -1) {
                nums[i] = -2;
            }
            while (val > 0 && val <= N) {
                int nextVal = nums[val - 1];
                nums[val - 1] = -1;
                val = nextVal;
            }
        }

        int r;
        for (r = 0; r < N; r++) {
            if (nums[r] != -1)
                break;
        }

        return r + 1;
    }
}
