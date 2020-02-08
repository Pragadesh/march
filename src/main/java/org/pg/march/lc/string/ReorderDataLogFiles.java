package org.pg.march.lc.string;

import java.util.Comparator;

/*
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataLogFiles {

	public String[] reorderLogFiles(String[] logs) {
		String[] aux = new String[logs.length];
		LogComparator comparator = new LogComparator();
		mergeSort(logs, 0, logs.length - 1, aux, comparator);
		return logs;
	}

	private void mergeSort(String[] logs, int lo, int hi, String[] aux, Comparator<String> comparator) {
		if (lo >= hi)
			return;

		int mid = (lo + hi) / 2;
		mergeSort(logs, lo, mid, aux, comparator);
		mergeSort(logs, mid + 1, hi, aux, comparator);
		for (int i = lo; i <= hi; i++) {
			aux[i] = logs[i];
		}
		int i = lo;
		int j = mid+1;
		while(i <= mid && j <= hi) {
			int compare = comparator.compare(aux[i], aux[j]);
			if(compare <= 0) {
				logs[lo++] = aux[i++];
			}else {
				logs[lo++] = aux[j++];
			}
		}
		while(i <= mid) {
			logs[lo++] = aux[i++];
		}
		while(j <= hi) {
			logs[lo++] = aux[j++];
		}
	}
	
	private class LogComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			String[] str1 = o1.split(" ");
			String[] str2 = o2.split(" ");
			boolean isDigit1 = Character.isDigit(str1[1].charAt(0)); 
			boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
			if(isDigit1 && isDigit2) {
				return 0;
			}else if(isDigit1) {
				return 1;
			}else if(isDigit2) {
				return -1;
			}else {
				int compare = recursiveCompare(str1, str2, 1);
				if(compare == 0) {
					return str1[0].compareTo(str2[0]);
				}
				return compare;
			}
		}
		
		private int recursiveCompare(String[] str1, String[] str2, int index) {
			if(str1.length > index && str2.length > index) {
				int compare = str1[index].compareTo(str2[index]);
				if(compare == 0) {
					return recursiveCompare(str1, str2, index + 1);
				}
				return compare;
			}else if(str1.length > index) {
				return 1;
			}else if(str2.length > index) {
				return -1;
			}else {
				return 0;
			}
		}
		
	}
}
