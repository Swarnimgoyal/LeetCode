class Solution {
    public int missingInteger(int[] nums) {

        Set<Integer> s = new HashSet<>();

        // Store all numbers
        for (int x : nums) {
            s.add(x);
        }

        // Find sum of longest consecutive prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find smallest number >= sum that is not present
        while (s.contains(sum)) {
            sum++;
        }

        return sum;
    }
}