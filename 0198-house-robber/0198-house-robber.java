class Solution {
    int solve(int[] nums,int n,int[] dp){
        if(n<0)return 0;
        if(n==0)return nums[0];
        if(dp[n]!=-1)return dp[n];
        int incl=solve(nums,n-2,dp)+nums[n];
        int excl=solve(nums,n-1,dp)+0;
        dp[n]=Math.max(incl,excl);
        return dp[n];
    }
    public int rob(int[] nums) {
        int n= nums.length;
        int [] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=solve(nums,n-1,dp);
        return ans;
        
    }
}