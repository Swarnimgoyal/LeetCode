class Solution {
    public int repeatedNTimes(int[] nums) {
        int m=nums.length;
        int n=m/2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i]) == n) return nums[i];

        }
        return -1;
    }
}