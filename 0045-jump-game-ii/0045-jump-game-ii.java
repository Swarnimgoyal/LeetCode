class Solution {
    public int jump(int[] nums) {
        int j=0;
        int e=0;
        int mr=0;
        for(int i=0;i<nums.length-1;i++){
            mr=Math.max(mr,i+nums[i]);
            if(i==e){
                j++;
                e=mr;
            }
        }
        return j;
    }
}