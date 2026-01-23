class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(1,k,n,new ArrayList<Integer>(),res);
        return res;
    }
    public void backtrack (int start ,int k, int rem, ArrayList<Integer> curr,List<List<Integer>> res){
        if(curr.size()==k && rem==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()>k||rem<0){
            return;
        }
        for(int i=start;i<=9;i++){
            curr.add(i);
            backtrack(i+1,k,rem-i,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}