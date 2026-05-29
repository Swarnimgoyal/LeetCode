class Solution {
    public int minElement(int[] nums) {
        int m =Integer.MAX_VALUE;

        for(int n: nums){
            int s=0;
            int a=n;
            while(a/10>0){
                s+=a%10;
                a/=10;
            }
            s+=a%10;
            m=Math.min(m,s);
        }
        return m;
    }
}