import java.util.*;

class Solution {
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        dp = new int[n][2][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(prices, 0, 1, k);
    }

    int solve(int[] prices, int idx, int buy, int cap) {

        // No days left or no transactions left
        if (idx == prices.length || cap == 0) {
            return 0;
        }

        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        int profit;

        if (buy == 1) {

            // Buy
            int take = -prices[idx] +
                    solve(prices, idx + 1, 0, cap);

            // Don't buy
            int notTake =
                    solve(prices, idx + 1, 1, cap);

            profit = Math.max(take, notTake);

        } else {

            // Sell -> transaction completed, so cap decreases
            int sell = prices[idx] +
                    solve(prices, idx + 1, 1, cap - 1);

            // Don't sell
            int notSell =
                    solve(prices, idx + 1, 0, cap);

            profit = Math.max(sell, notSell);
        }

        return dp[idx][buy][cap] = profit;
    }
}