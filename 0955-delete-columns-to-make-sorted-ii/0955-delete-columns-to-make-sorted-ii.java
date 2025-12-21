class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] sorted = new boolean[n]; // sorted[i] => strs[i-1] < strs[i]
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean needDelete = false;

            // check if this column breaks lexicographic order
            for (int i = 1; i < n; i++) {
                if (!sorted[i] && strs[i - 1].charAt(col) > strs[i].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }

            if (needDelete) {
                deletions++;
                continue;
            }

            // update sorted status
            for (int i = 1; i < n; i++) {
                if (!sorted[i] && strs[i - 1].charAt(col) < strs[i].charAt(col)) {
                    sorted[i] = true;
                }
            }
        }

        return deletions;
    }
}
