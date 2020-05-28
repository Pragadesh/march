package org.pg.march.lc.num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {

    List<List<Integer>> result;
    private int len;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.result = new ArrayList<>();
        this.len = nums.length;

        int k = 4;
        Arrays.sort(nums);
        findKthSum(nums, 0, target, k, null);

        return result;
    }

    private void findKthSum(int nums[], int index, int target, int k, List<Integer> current) {
        if (k == 2) {
            int left = index;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    if (current == null) {
                        result.add(Arrays.asList(nums[left], nums[right]));
                    } else {
                        current.add(nums[left]);
                        current.add(nums[right]);
                        result.add((ArrayList<Integer>) ((ArrayList<Integer>) current).clone());
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        } else {
            for (int i = index; i < len - k; i++) {
                if (i == index || (i > index && nums[i] != nums[i - 1])) {
                    List<Integer> newList = current;
                    if (newList == null)
                        newList = new ArrayList<>();
                    newList.add(nums[i]);
                    findKthSum(nums, i + 1, target - nums[i], k - 1, newList);
                }
            }
        }
    }

    public List<List<Integer>> fourSumNonRecursive(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null)
            return result;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < len - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int expected = target - nums[i] - nums[j];
                        int left = j + 1;
                        int right = len - 1;
                        while (left < right) {
                            int sum = nums[left] + nums[right];
                            if (sum == expected) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left + 1]) {
                                    left++;
                                }
                                left++;
                                right--;
                            } else if (sum > expected) {
                                right--;
                            } else {
                                left++;
                            }
                        }
                    }
                }

            }
        }
        return result;
    }
}
