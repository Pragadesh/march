package org.pg.march.lc.minimax;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/can-i-win/
 */
public class CanIWin {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		boolean[] used = new boolean[maxChoosableInteger + 1];
		int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
		if(desiredTotal <= 0) 
			return true;
        if(sum < desiredTotal)
        	return false;
		Map<Integer, Boolean> memo = new HashMap<>();
		return isWinning(desiredTotal, used, memo);
	}

	private boolean isWinning(int desiredTotal, boolean[] used, Map<Integer, Boolean> memo) {
		if (desiredTotal <= 0) {
			return false;
		}
		int status = toInt(used);
		if (memo.containsKey(status)) {
			return memo.get(status);
		} else {
			for (int i = 1; i < used.length; i++) {
				if (!used[i]) {
					used[i] = true;
					if (!isWinning(desiredTotal - i, used, memo)) {
						used[i] = false;
						memo.put(status, true);
						return true;
					}
					used[i] = false;
				}
			}
			memo.put(status, false);
			return false;
		}
	}

	private int toInt(boolean[] used) {
		int num = 0;
		for (int i = used.length - 1; i > 0; i--) {
			num <<= 1;
			if (used[i])
				num |= 1;
		}
		return num;
	}
}
