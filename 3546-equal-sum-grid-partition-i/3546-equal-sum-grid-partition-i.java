class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        // Handle edge cases for empty or invalid grids
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return false;
        }

        int m = grid.length;
        int n = grid[0].length;
        
        // Use 'long' to prevent integer overflow on large grids
        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        long totalSum = 0;

        // 1. Precalculate the sum of each row, each column, and the total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                rowSums[i] += val;
                colSums[j] += val;
                totalSum += val;
            }
        }

        // 2. If the total sum is odd, we can't divide it equally
        if (totalSum % 2 != 0) {
            return false;
        }

        long target = totalSum / 2;

        // 3. Check for a valid horizontal cut
        // We iterate up to m-1 to ensure the bottom section is non-empty
        long currentRowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            currentRowSum += rowSums[i];
            if (currentRowSum == target) {
                return true;
            }
        }

        // 4. Check for a valid vertical cut
        // We iterate up to n-1 to ensure the right section is non-empty
        long currentColSum = 0;
        for (int j = 0; j < n - 1; j++) {
            currentColSum += colSums[j];
            if (currentColSum == target) {
                return true;
            }
        }

        // If neither cut works, return false
        return false;
    }
}