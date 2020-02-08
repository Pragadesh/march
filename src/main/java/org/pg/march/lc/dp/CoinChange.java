package org.pg.march.lc.dp;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if(amount == 0) return 0;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		for(int coin : coins) {
			if(coin <= amount)
				dp[coin] = 1;
		}
		for(int i=1; i<= amount; i++) {
			
			for(int coin : coins) {
				if(i > coin && dp[coin] > 0 && dp[i-coin] > 0) {
					dp[i] = Math.min(dp[i], dp[coin] + dp[i-coin]);
				}
			}

		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
