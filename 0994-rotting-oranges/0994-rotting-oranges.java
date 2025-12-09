class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>(); // store {r, c}
        int fresh = 0;

        // Collect initial rotten oranges and count fresh ones
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // If there are no fresh oranges at all
        if (fresh == 0) return 0;

        int minutes = -1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // BFS level by level
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;      // become rotten
                        fresh--;               // one less fresh orange
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            minutes++;
        }

        // If some fresh oranges couldn't be rotten
        return (fresh == 0) ? minutes : -1;
    }
}