class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        long ans = 1;

        int seats = 0;
        int plantsBetween = 0;
        boolean firstSection = true;

        for (int i = 0; i < n; i++) {
            char ch = corridor.charAt(i);

            if (ch == 'S') {
                seats++;

                if (seats == 2) {
                    if (!firstSection) {
                        ans = (ans * (plantsBetween + 1)) % MOD;
                    }
                    firstSection = false;
                    seats = 0;
                    plantsBetween = 0;
                }
            } else { // 'P'
                if (seats == 0 && !firstSection) {
                    plantsBetween++;
                }
            }
        }

        // 🔴 CRITICAL CHECK: incomplete section
        if (seats != 0) return 0;

        // no valid section formed
        if (firstSection) return 0;

        return (int) ans;
    }
}
