package org.pg.march.util;

import java.util.List;

public class ArrayUtil {

	public static int[] toIntArray(List<Integer> list) {
		if(list == null) {
			return null;
		}
		return list.stream().mapToInt(i -> i).toArray();
	}
	
}
