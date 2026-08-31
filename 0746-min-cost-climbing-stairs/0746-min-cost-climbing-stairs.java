class Solution {
    int [] dp;
    public int solve(int i,int[] cost){
        if(i<=1){
            return cost[i];
        }
        if(dp[i]!=-1)return dp[i];
        return dp[i]=cost[i]+Math.min(solve(i-1,cost),solve(i-2,cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(solve(n-1,cost),solve(n-2,cost));
    }
}