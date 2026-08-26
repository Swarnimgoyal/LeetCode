class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int n=nums.length;
        int [] res= new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            if(!q.isEmpty()&&q.peekFirst()<=i-k){
                q.pollFirst();
            }
            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offerLast(i);
            if(i>=k-1){
                res[idx++]=nums[q.peekFirst()];
            }            
        }
        return res;
    }
}