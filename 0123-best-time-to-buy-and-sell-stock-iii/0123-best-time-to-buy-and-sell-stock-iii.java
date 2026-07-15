class Solution {
    int [][][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;

        dp =new int [n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(prices,0,1,2);
    }
    int solve(int [] prices,int idx,int buy,int cap){
        if(idx==prices.length||cap==0){
            return 0;
        }
        if(dp[idx][buy][cap]!=-1){
            return dp[idx][buy][cap];
        }
        int profit;
        if(buy==1){
            int take=-prices[idx]+solve(prices,idx+1,0,cap);
            int not_take=solve(prices,idx+1,1,cap);
            profit=Math.max(take,not_take);
        }else{
            int sell=+prices[idx]+solve(prices,idx+1,1,cap-1);
            int not_sell=solve(prices,idx+1,0,cap);
            profit=Math.max(sell,not_sell);
        }
        return dp[idx][buy][cap]=profit;

    }
}