class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> s=new HashSet<>();
        for(int n: nums){
            if(s.contains(n)){
                return n;
            }
            s.add(n);
        }
        return -1;
    }
}