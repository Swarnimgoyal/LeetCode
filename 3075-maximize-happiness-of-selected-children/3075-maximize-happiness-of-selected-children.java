class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int dec = 0;

        for (int i = happiness.length - 1; i >= 0 && k > 0; i--) {
            int val = happiness[i] - dec;
            if (val <= 0) break;

            ans += val;
            dec++;
            k--;
        }
        return ans;
    }
}
