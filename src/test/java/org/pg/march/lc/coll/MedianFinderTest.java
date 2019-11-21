package org.pg.march.lc.coll;

import org.junit.Test;

import junit.framework.Assert;

public class MedianFinderTest {

	@Test
	public void testcase1() {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);
		medianFinder.addNum(2);
		Assert.assertEquals(1.5d, medianFinder.findMedian()); // returns 1.5
		medianFinder.addNum(3);
		Assert.assertEquals(2d, medianFinder.findMedian()); // returns 2
	}
	
	@Test
	public void testcase2() {
		MedianFinder medianFinder = new MedianFinder();
		int n = 1000;
		int i;
		for (i = 1; i < n / 2; i++) {
			medianFinder.addNum(i);
			medianFinder.addNum(n - i);
		}
		medianFinder.addNum(i);
		System.out.println(medianFinder.findMedian());
	}
	
	@Test
	public void testcase3() {
		MedianFinder medianFinder = new MedianFinder();
		int nums[] = { 155, 66, 114, 0, 60, 73, 109, 26, 154, 0, 107, 75, 9, 57, 53, 6, 85, 151, 12, 110, 64, 103, 42,
				103, 126, 3, 88, 142, 79, 88, 147, 47, 134, 27, 82, 95, 26, 124, 71, 79, 130, 91, 131, 67, 64, 16, 60,
				156, 9, 65, 21, 66, 49, 108, 80, 17, 159, 24, 90, 79, 31, 79, 113, 39, 54, 156, 139, 8, 90, 19, 10, 50,
				89, 77, 83, 13, 3, 71, 52, 21, 50, 120, 159, 45, 22, 69, 144, 158, 19, 109, 52, 50, 51, 62, 20, 22, 71,
				95, 47, 12, 21, 32, 17, 130, 109, 8, 61, 13, 48, 107, 14, 122, 62, 54, 70, 96, 11, 141, 129, 157, 136,
				41, 40, 78, 141, 16, 137, 127, 19, 70, 15, 16, 65, 96, 157, 111, 87, 95, 52, 42, 12, 60, 17, 20, 63, 56,
				37, 129, 67, 129, 106, 107, 133, 80, 8, 56, 72, 81, 143, 90, 0 };
		for (int i = 0; i < nums.length; i++) {
			System.out.println(String.format("Adding %d", nums[i]));
			medianFinder.addNum(nums[i]);
			System.out.println(String.format("Median after adding %d: %.2f", nums[i], medianFinder.findMedian()));
		}
		System.out.println("Finished");
	}
}
