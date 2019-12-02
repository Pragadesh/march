package org.pg.march.lc.coll;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/sliding-window-median/
 */
public class SlidingWindowMedian {

	public double[] medianSlidingWindow(int[] nums, int k) {
		int[] window = new int[k];
		for (int i = 0; i < k; i++) {
			window[i] = nums[i];
		}
		Arrays.sort(window);
		double[] m = new double[nums.length - k + 1];
		m[0] = median(window, k);
		for (int i = k; i < nums.length; i++) {
			int pos = findElementPos(window, nums[i - k]);
			window[pos] = nums[i];
			if (pos > 0 && window[pos] < window[pos - 1]) {
				while (pos > 0 && window[pos] < window[pos - 1]) {
					swap(window, pos, --pos);
				}
			} else if (pos < k - 1 && window[pos] > window[pos + 1]) {
				while (pos < k - 1 && window[pos] > window[pos + 1]) {
					swap(window, pos, ++pos);
				}
			}
			m[i + 1 - k] = median(window, k);
		}

		return m;
	}

	private void swap(int[] window, int i, int j) {
		int temp = window[i];
		window[i] = window[j];
		window[j] = temp;
	}

	private int findElementPos(int[] window, int e) {
		return findElementPos(window, 0, window.length - 1, e);
	}

	private int findElementPos(int[] window, int lo, int hi, int e) {
		if (lo > hi) {
			return -1;
		}
		int mid = (lo + hi) / 2;
		int curr = window[mid];
		if (curr == e) {
			return mid;
		} else if (e > curr) {
			return findElementPos(window, mid + 1, hi, e);
		} else {
			return findElementPos(window, lo, mid - 1, e);
		}
	}

	private double median(int[] window, int k) {
		int i = (k - 1) / 2;
		double m = window[i];
		if (k % 2 == 0) {
			m = (m + window[i + 1]) * 0.5;
		}
		return m;
	}
}
