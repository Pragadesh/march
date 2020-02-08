package org.pg.march.lc.coll;

import java.util.ArrayList;
import java.util.List;

public interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value);

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni);

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();

	public class NestedIntegerImpl implements NestedInteger {

		private int value;
		List<NestedInteger> list = new ArrayList<>();

		// Constructor initializes an empty nested list.
		public NestedIntegerImpl() {

		}

		// Constructor initializes a single integer.
		public NestedIntegerImpl(int value) {
			this.value = value;
		}

		@Override
		public boolean isInteger() {
			return list.isEmpty() || value > 0;
		}

		@Override
		public Integer getInteger() {
			return value;
		}

		@Override
		public void setInteger(int value) {
			this.value = value;
		}

		@Override
		public void add(NestedInteger ni) {
			list.add(ni);
		}

		@Override
		public List<NestedInteger> getList() {
			return list;
		}
	}
}
