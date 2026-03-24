class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;

        int total = n * m;
        long[] arr = new long[total];

        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[k++] = grid[i][j];
            }
        }

        long[] prefix = new long[total];
        long[] suffix = new long[total];

        prefix[0] = 1;
        for(int i = 1; i < total; i++){
            prefix[i] = (prefix[i-1] * arr[i-1]) % mod;
        }

        suffix[total-1] = 1;
        for(int i = total-2; i >= 0; i--){
            suffix[i] = (suffix[i+1] * arr[i+1]) % mod;
        }

        int[][] ans = new int[n][m];
        k = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = (int)((prefix[k] * suffix[k]) % mod);
                k++;
            }
        }

        return ans;
    }
}