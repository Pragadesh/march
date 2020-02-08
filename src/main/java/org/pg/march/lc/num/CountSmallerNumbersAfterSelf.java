package org.pg.march.lc.num;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class CountSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;

        int res[] = new int[N];
        int index[] = new int[N];
        int auxIndex[] = new int[N];

        for (int i = 1; i < N; i++) {
            index[i] = i;
        }
        mergeSort(index, auxIndex, 0, N - 1, nums, res);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            result.add(res[i]);
        }
        return result;
    }

    private void mergeSort(int index[], int auxIndex[], int left, int right, int[] nums, int res[]) {
        if(left >= right) return;
        int mid = (right + left) / 2;
        mergeSort(index, auxIndex, left, mid, nums, res);
        mergeSort(index, auxIndex, mid+1, right, nums, res);
        for(int i = left; i<= right; i++) {
            auxIndex[i] = index[i];
        }
        int y = mid + 1;
        int x = left;
        int i = left;
        int num = 0;
        while(x <= mid && y <= right) {
            if(nums[auxIndex[y]] < nums[auxIndex[x]]) {
                index[i++] = auxIndex[y++];
                num++;
            }else {
                res[auxIndex[x]] += num;
                index[i++] = auxIndex[x++];
            }
        }
        while ( x <= mid) {
            res[auxIndex[x]] += num;
            index[i++] = auxIndex[x++];
        }
    }
}
