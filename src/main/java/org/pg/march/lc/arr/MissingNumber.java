package org.pg.march.lc.arr;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        int N = nums.length;
        for (int i = 0; i < N; i++) {
            while (nums[i] >= 0 && nums[i] < N && nums[i] != nums[nums[i]]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i != nums[i])
                return i;
        }

        return N;
    }
}
