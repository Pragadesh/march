package org.pg.march.lc.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/*
 * https://leetcode.com/problems/brace-expansion/
 */
public class BraceExpansion {

//	public String[] expand(String S) {
//		char[] chArr = S.toCharArray();
//		List<String> res = expand(chArr, 0, chArr.length - 1);
//		String[] resArr = new String[res.size()];
//		return res.toArray(resArr);
//	}
	
	public List<String> braceExpansionII(String expression) {
		char[] chArr = expression.toCharArray();
		Set<String> res = expand(chArr, 0, chArr.length - 1);
		List<String> ans = new ArrayList<>(res);
		Collections.sort(ans);
		return ans;
    }

	public Set<String> expand(char[] chArr, int start, int end) {
		if(start > end) return new HashSet<>(); 
		Set<String> res = new HashSet<>();
		Deque<Set<String>> deque = new LinkedList<>();
		deque.offer(new HashSet<>(Arrays.asList("")));
		char operation = '*';
		for (int i = start; i <= end; i++) {
			char ch = chArr[i];

			if (ch == '{') {
				int j = i + 1, p = 1;
				while (chArr[j] != '}' || p > 1) {
					if (chArr[j] == '{') {
						p++;
					} else if (chArr[j] == '}') {
						p--;
					}
					j++;
				}
				Set<String> nestedWords = expand(chArr, i+1, j-1);
				i = j;
				if(operation == '*') {
					deque.offer(merge(deque.pollLast(), nestedWords));
				}else {
					operation = '*';
					deque.offer(nestedWords);
				}
			} else if(Character.isAlphabetic(ch)) {
				Set<String> set = new HashSet<>(Arrays.asList(Character.toString(ch)));
				if(operation == '*') {
					deque.offer(merge(deque.pollLast(), set));
				}else {
					operation = '*';
					deque.offer(set);
				}
			}
//			if (ch == ',' || i == chArr.length - 1) {
			if (ch == ',') {
				operation = ',';
			}
		}
		while(!deque.isEmpty()) {
			res.addAll(deque.pollLast());
		}
		return res;
	}

	private Set<String> merge(Set<String> list1, Set<String> list2) {
		Set<String> res = new HashSet<>();
		for(String str1 : list1) {
			for(String str2 : list2) {
				res.add(str1 + str2);
			}
		}
		return res;
	}
}
