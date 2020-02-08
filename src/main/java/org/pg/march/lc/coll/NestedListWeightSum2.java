package org.pg.march.lc.coll;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
public class NestedListWeightSum2 {

	public int depthSumInverse(List<NestedInteger> nestedList) {
		int sum = 0;
		int levelSum = 0;
		while (!nestedList.isEmpty()) {
			System.out.println("Processing size: "+nestedList.size());
			List<NestedInteger> nextLevel = new ArrayList<>();
			for (NestedInteger nested : nestedList) {
				if (nested.isInteger()) {
					levelSum += nested.getInteger();
				} else {
					nextLevel.addAll(nested.getList());
				}
			}
			sum += levelSum;
			nestedList = nextLevel;
		}
		return sum;
	}
}
