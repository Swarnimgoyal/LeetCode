class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> s= new HashSet<>();
        int res[]=new int[2];
        int i=0;
        for(int c:nums){
            if(s.contains(c)){
                res[i]=c;
                i++;
                if(i==2)return res;
            }
            else{
                s.add(c);
            }
        }
        return res;
    }
}