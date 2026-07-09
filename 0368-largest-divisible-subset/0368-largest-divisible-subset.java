class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] par = new int[n];

        Arrays.fill(dp, 1);

        int ml = 1;
        int li = 0;

        for (int i = 0; i < n; i++) {

            par[i] = i;

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    par[i] = j;
                }
            }

            if (dp[i] > ml) {
                ml = dp[i];
                li = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (par[li] != li) {
            ans.add(nums[li]);
            li = par[li];
        }

        ans.add(nums[li]);

        Collections.reverse(ans);

        return ans;
    }
}