

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] second = new int[m][2];
        for (int i = 0; i < m; i++) {
            second[i][0] = secondStart[i];
            second[i][1] = secondDur[i];
        }

        Arrays.sort(second, (a, b) -> Integer.compare(a[0], b[0]));

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = second[i][0];
        }

        prefixMinDur[0] = second[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], second[i][1]);
        }

        suffixMinStartPlusDur[m - 1] =
                (long) second[m - 1][0] + second[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinStartPlusDur[i] = Math.min(
                    suffixMinStartPlusDur[i + 1],
                    (long) second[i][0] + second[i][1]
            );
        }

        long res = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst = (long) firstStart[i] + firstDur[i];

            int pos = upperBound(starts, (int) finishFirst);

            // rides with start <= finishFirst
            if (pos > 0) {
                res = Math.min(res,
                        finishFirst + prefixMinDur[pos - 1]);
            }

            // rides with start > finishFirst
            if (pos < m) {
                res = Math.min(res,
                        suffixMinStartPlusDur[pos]);
            }
        }

        return res;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}