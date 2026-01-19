class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        
        // Prefix sum array
        int[][] ps = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = mat[i - 1][j - 1]
                         + ps[i - 1][j]
                         + ps[i][j - 1]
                         - ps[i - 1][j - 1];
            }
        }
        
        int low = 0, high = Math.min(m, n);
        
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (existsSquare(ps, mid, threshold)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private boolean existsSquare(int[][] ps, int k, int threshold) {
        for (int i = 0; i + k < ps.length; i++) {
            for (int j = 0; j + k < ps[0].length; j++) {
                int sum = ps[i + k][j + k]
                        - ps[i][j + k]
                        - ps[i + k][j]
                        + ps[i][j];
                
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
