class Solution {
    int [][]dp;
    public int maxProfit(int[] prices, int fee) {
    int n = prices.length;

        dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(prices, 0, 1,fee);
    }

    int solve(int[] prices, int idx, int buy,int fee) {

        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        int profit;

        if (buy == 1) {

            // Buy
            int take = -prices[idx] +
                    solve(prices, idx + 1, 0,fee);

            // Don't buy
            int notTake =
                    solve(prices, idx + 1, 1,fee);

            profit = Math.max(take, notTake);

        } else {

            // Sell
            int sell = prices[idx] - fee+
                    solve(prices, idx + 1, 1,fee);

            // Don't sell
            int notSell =
                    solve(prices, idx + 1, 0,fee);

            profit = Math.max(sell, notSell);
        }

        return dp[idx][buy] = profit;
    }
}