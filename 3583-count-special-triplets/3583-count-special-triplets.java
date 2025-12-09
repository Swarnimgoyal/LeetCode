import java.util.HashMap;

class Solution {
    static final long MOD = 1_000_000_007L;

    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        // Build right frequency map
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        long count = 0;

        for (int i = 0; i < nums.length; i++) {

            // This element becomes the middle element (j), so remove it from right
            int cur = nums[i];
            right.put(cur, right.get(cur) - 1);
            if (right.get(cur) == 0) {
                right.remove(cur);
            }

            // target value: nums[i] * 2
            int a = cur * 2;

            Integer leftCount = left.get(a);
            Integer rightCount = right.get(a);

            if (leftCount != null && rightCount != null) {
                long add = (long) leftCount * rightCount;
                count = (count + add) % MOD;
            }

            // now cur goes to left side
            left.put(cur, left.getOrDefault(cur, 0) + 1);
        }

        return (int) (count % MOD);
    }
}
