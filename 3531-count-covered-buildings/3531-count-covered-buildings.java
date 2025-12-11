import java.util.*;

class Solution {
    // encode a coordinate into a long key
    private static long key(int x, int y) {
        return (((long)x) << 32) | (y & 0xffffffffL);
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        // maps row(y) -> list of x's in that row
        Map<Integer, ArrayList<Integer>> rowMap = new HashMap<>();
        // maps col(x) -> list of y's in that column
        Map<Integer, ArrayList<Integer>> colMap = new HashMap<>();
        // set of all coords for final counting
        Set<Long> coords = new HashSet<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMap.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            colMap.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            coords.add(key(x, y));
        }

        Map<Long, Boolean> hasLeftRight = new HashMap<>();
        Map<Long, Boolean> hasUpDown = new HashMap<>();

        // process rows -> determine for each coordinate if it has both left and right
        for (Map.Entry<Integer, ArrayList<Integer>> e : rowMap.entrySet()) {
            int y = e.getKey();
            ArrayList<Integer> xs = e.getValue();
            Collections.sort(xs);
            int sz = xs.size();
            for (int i = 0; i < sz; ++i) {
                long k = key(xs.get(i), y);
                // has both left and right if not first and not last in sorted row
                hasLeftRight.put(k, i > 0 && i < sz - 1);
            }
        }

        // process columns -> determine for each coordinate if it has both up and down
        for (Map.Entry<Integer, ArrayList<Integer>> e : colMap.entrySet()) {
            int x = e.getKey();
            ArrayList<Integer> ys = e.getValue();
            Collections.sort(ys);
            int sz = ys.size();
            for (int i = 0; i < sz; ++i) {
                long k = key(x, ys.get(i));
                // has both down and up if not first and not last in sorted column
                hasUpDown.put(k, i > 0 && i < sz - 1);
            }
        }

        int covered = 0;
        for (long k : coords) {
            if (hasLeftRight.getOrDefault(k, false) && hasUpDown.getOrDefault(k, false)) {
                covered++;
            }
        }
        return covered;
    }

    // optional main for quick local test
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int[][] buildings = { {1,2}, {3,2}, {2,1}, {2,3}, {2,2} };
        System.out.println(s.countCoveredBuildings(n, buildings)); // expected 1
    }
}
