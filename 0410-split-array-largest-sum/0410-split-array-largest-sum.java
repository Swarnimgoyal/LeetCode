class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        for(int n: nums){
            low=Math.max(low,n);
            high+=n;
        }
        while(low<high){
            int mid=low +(high-low)/2;
            if(canSplit(nums,k,mid)){
                high=mid;
            }else{
                low=mid+1;

            }
        }
        return low;
    }
    public boolean canSplit(int [] nums,int k ,int maxsum){
        int count=1;
        int currsum=0;
        for(int n :nums){
            currsum+=n;
            if(currsum>maxsum){
                count++;
                currsum=n;
                if(count>k)return false;
            }
        }
        return true;
    }
}