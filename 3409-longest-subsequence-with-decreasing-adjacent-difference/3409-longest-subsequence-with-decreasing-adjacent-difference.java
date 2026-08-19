class Solution {
    public int longestSubsequence(int[] nums) {

        // best[value][diff] =
        // maximum length of a valid subsequence
        // ending with 'value' whose last difference >= diff
        int[][] best = new int[301][301];

        boolean[] seen = new boolean[301];

        int ans = 1;

        for (int x : nums) {

            int[] cur = new int[301];

            // Try every possible previous value
            for (int y = 0; y <= 300; y++) {

                if (!seen[y]) {
                    continue;
                }

                int diff = Math.abs(x - y);

                // Previous difference must be >= current difference
                cur[diff] = Math.max(
                    cur[diff],
                    best[y][diff] + 1
                );

                // At least [y, x] is a valid subsequence
                cur[diff] = Math.max(cur[diff], 2);
            }

            // Update best[x]
            for (int d = 300; d >= 0; d--) {

                if (cur[d] > best[x][d]) {
                    best[x][d] = cur[d];
                }

                // Make best[x][d] = max for all differences >= d
                if (d < 300) {
                    best[x][d] = Math.max(
                        best[x][d],
                        best[x][d + 1]
                    );
                }

                ans = Math.max(ans, best[x][d]);
            }

            seen[x] = true;
        }

        return ans;
    }
}