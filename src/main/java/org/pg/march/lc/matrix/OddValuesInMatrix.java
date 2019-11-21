package org.pg.march.lc.matrix;

public class OddValuesInMatrix {

	public int oddCells(int n, int m, int[][] indices) {

		int[] rows = new int[n];
		int[] cols = new int[m];
		for (int[] index : indices) {
			rows[index[0]]++;
			cols[index[1]]++;
		}
		int odd = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if ((rows[row] + cols[col]) % 2 == 1) {
					odd++;
				}
			}
		}
		return odd;
	}

}
