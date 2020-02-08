package org.pg.march.lc.coll;

import java.util.List;

/*
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
public class NestedListWeightSum {

	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(1, nestedList);
	}

	private int depthSum(int level, List<NestedInteger> nestedList) {
		if (nestedList == null) return 0;
		int sum = 0;
		for (NestedInteger nested : nestedList) {
			if(nested.isInteger()) {
				sum += (level * nested.getInteger());
			}else {
				sum += depthSum(level + 1, nested.getList());
			}
		}
		return sum;
	}
}
