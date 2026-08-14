class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> m=new HashMap<>();

        int left=0;
        int ans=0;

        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            m.put(ch,m.getOrDefault(ch,0)+1);
            while(m.get(ch)>2){
                char lc=s.charAt(left);
                m.put(lc,m.get(lc)-1);
                left++;
            }
            ans=Math.max(ans,r-left+1);
        }
        return ans;
    }
}