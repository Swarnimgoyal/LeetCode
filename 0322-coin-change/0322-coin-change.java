class Solution {
    /*int solverecur(int [] coins,int amount){
        if(amount==0){
            return 0;
        }
        if(amount<0)return Integer.MAX_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=solverecur(coins,amount-coins[i]);
            if(ans!=Integer.MAX_VALUE){
                mini=Math.min(mini,1+ans);
            }
        }
        return mini;
    }*/
    int solvemem(int[] coins,int amount,int [] dp){
        if(amount==0)return 0;
        if(amount<0)return Integer.MAX_VALUE;
        if(dp[amount]!=-1)return dp[amount];

        int mini=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=solvemem(coins,amount-coins[i],dp);
            if(ans!=Integer.MAX_VALUE){
                mini=Math.min(mini,1+ans);
            }
        }
        dp[amount]=mini;
        return mini;
    }
    

    public int coinChange(int[] coins, int amount) {
     /*int ans=solverecur(coins,amount);
     if(ans==Integer.MAX_VALUE)return -1;
     return ans;*/
     
     int dp [] =new int[amount+1];
     Arrays.fill(dp,-1);
     int ans=solvemem(coins,amount,dp);
     if(ans==Integer.MAX_VALUE){
        return -1;
     }
     return ans;
    }
}