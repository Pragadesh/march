package org.pg.march.util;

public class MathUtil {

	public long factorial(int n) {
		long res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	public long combination(int n, int r) {
		int c = r > n / 2 ? r : (n - r);
		long res = 1;
		for (int i = c + 1; i <= n; i++) {
			res *= i;
		}
		for (int i = 1; i <= (n - c); i++) {
			res /= i;
		}
		return res;
	}
	
	public long allPossibleCombination(int n) {
		long res = 0;
		for (int r = 1; r <= n; r++) {
			res += combination(n, r);
		}
		return res;
	}
}
