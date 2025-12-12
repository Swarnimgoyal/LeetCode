import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        boolean[][] seen = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        // Enqueue all 'O's on the border (they are safe)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (board[i][j] == 'O') {
                        seen[i][j] = true;
                        q.addLast(new int[]{i, j});
                    }
                }
            }
        }

        // BFS from border 'O's to mark all connected 'O's as safe
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int r = cur[0], c = cur[1];
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !seen[nr][nc] && board[nr][nc] == 'O') {
                    seen[nr][nc] = true;
                    q.addLast(new int[]{nr, nc});
                }
            }
        }

        // Flip all non-safe 'O's to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !seen[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
