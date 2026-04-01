class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i=i+2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        return -1;
    }
}