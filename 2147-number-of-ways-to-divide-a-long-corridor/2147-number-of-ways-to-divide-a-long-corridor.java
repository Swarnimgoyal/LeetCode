class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        long ways=1;
        int seats=0;
        int last=-1;
        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S'){
                seats++;
                if(seats>=3&&seats%2==1){
                        ways=(ways*(i-last))%MOD;
                }
                last=i;
            }
        }
        if (seats == 0 || seats % 2 == 1) return 0;

        return (int)ways;

    }
}
