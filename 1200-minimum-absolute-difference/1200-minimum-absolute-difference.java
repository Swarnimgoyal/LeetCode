import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        List<List<Integer>> res = new ArrayList<>();
        if (n < 2) return res;

        // Step 1: find minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        // Step 2: collect all pairs with minDiff
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return res;
    }
}
