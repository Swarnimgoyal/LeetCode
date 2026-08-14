class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
     List<List<Integer>> ans=new ArrayList<>();
     backtrack(k,n,1,new ArrayList<>(),ans);
     return ans;   
    }
    public void backtrack(int k,int rem,int start,ArrayList<Integer> curr,List<List<Integer>> ans){
        if(curr.size()==k&&rem==0){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        if(curr.size()>k||rem<0)return ;
        for(int i=start;i<=9;i++){
            curr.add(i);
            backtrack(k,rem-i,i+1,curr,ans);
            curr.remove(curr.size()-1);

        }

    }
}