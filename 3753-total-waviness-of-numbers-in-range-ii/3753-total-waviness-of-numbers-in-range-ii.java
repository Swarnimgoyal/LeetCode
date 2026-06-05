import java.util.*;

class Solution {

    static class Pair {
        long cnt;   // number of valid numbers
        long wav;   // total waviness

        Pair(long c, long w) {
            cnt = c;
            wav = w;
        }
    }

    private char[] digits;
    private Pair[][][][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n < 0) return 0;

        digits = Long.toString(n).toCharArray();

        dp = new Pair[digits.length + 1][2][2][3][11][11];

        return dfs(0, 1, 0, 0, 10, 10).wav;
    }

    private Pair dfs(int pos, int tight, int started,
                     int lenState, int last2, int last1) {

        if (pos == digits.length) {
            return new Pair(1, 0);
        }

        if (dp[pos][tight][started][lenState][last2][last1] != null) {
            return dp[pos][tight][started][lenState][last2][last1];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;

        long totalCnt = 0;
        long totalWav = 0;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                Pair nxt = dfs(pos + 1, ntight, 0, 0, 10, 10);

                totalCnt += nxt.cnt;
                totalWav += nxt.wav;
            } else {

                if (started == 0) {
                    Pair nxt = dfs(pos + 1, ntight, 1, 1, 10, d);

                    totalCnt += nxt.cnt;
                    totalWav += nxt.wav;
                }
                else if (lenState == 1) {
                    Pair nxt = dfs(pos + 1, ntight, 1, 2, last1, d);

                    totalCnt += nxt.cnt;
                    totalWav += nxt.wav;
                }
                else {
                    int add = 0;

                    boolean peak = (last1 > last2 && last1 > d);
                    boolean valley = (last1 < last2 && last1 < d);

                    if (peak || valley) add = 1;

                    Pair nxt = dfs(pos + 1, ntight, 1, 2, last1, d);

                    totalCnt += nxt.cnt;
                    totalWav += nxt.wav + nxt.cnt * add;
                }
            }
        }

        return dp[pos][tight][started][lenState][last2][last1]
                = new Pair(totalCnt, totalWav);
    }
}