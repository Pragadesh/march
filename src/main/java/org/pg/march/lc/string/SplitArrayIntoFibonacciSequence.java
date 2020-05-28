package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class SplitArrayIntoFibonacciSequence {

	public List<Integer> splitIntoFibonacci(String S) {

		int N = S.length();
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= N / 2; i++) {
			if(S.charAt(0) == '0' && i > i) break;
			for (int j = i + 1; j <= i + (N - i) / 2; j++) {
				int first = Integer.parseInt(S.substring(0, i));
				int second = Integer.parseInt(S.substring(i, j));
				answer.add(first);
				answer.add(second);
				String toValidate = S.substring(j);
				int noOfSlices = 0;
				while (toValidate != null && !toValidate.isEmpty()) {
					int sum = first + second;
					if (!toValidate.startsWith(Integer.toString(sum))) {
						answer.clear();
						break;
					}
					toValidate = toValidate.substring(Integer.toString(sum).length());
					noOfSlices++;
					answer.add(sum);
					first = second;
					second = sum;
					if (toValidate.length() == 0 && noOfSlices > 0) {
						return answer;
					}
				}
			}

		}

		return new ArrayList<>();
	}
}
