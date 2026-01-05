class Solution {
    public int sumFourDivisors(int[] nums) {
        int res = 0;

        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            int count = 0;
            int s = 0;

            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    if (i * i == n) {
                        count += 1;
                        s += i;
                    } else {
                        count += 2;
                        s += i;
                        s += (n / i);
                    }
                }
            }

            if (count == 4)
                res += s;
        }

        return res;
    }
}
