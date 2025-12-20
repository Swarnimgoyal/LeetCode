class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int l = strs[0].length();
        int c = 0;

        for (int i = 0; i < l; i++) {          // column
            for (int j = 1; j < n; j++) {      // row
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    c++;
                    break;   // delete this column, move to next
                }
            }
        }
        return c;
    }
}
