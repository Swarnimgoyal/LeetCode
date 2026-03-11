class Solution {
    public int bitwiseComplement(int n) {
          int mask = 0;
        int temp = n;
        if(n==0)return 1;
        
        // Create mask of all 1s
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp = temp >> 1;
        }

        return n ^ mask;

    }
}