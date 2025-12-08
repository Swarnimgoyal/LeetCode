class Solution {
    public int countTriples(int n) {
             int count = 0;
        
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c2 = a * a + b * b;   // a^2 + b^2
                int c = (int) Math.sqrt(c2);
                
                // check if c is integer and within range
                if (c * c == c2 && c <= n) {
                    count++;
                }
            }
        }
        
        return count;
    }
}