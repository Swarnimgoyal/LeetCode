class Solution {
    public int maxVowels(String s, int k) {
        int left=0;
        int ans=0;
        int fa=0;
        Set<Character> st = new HashSet<>();

st.add('a');
st.add('e');
st.add('i');
st.add('o');
st.add('u');
        char[] arr=s.toCharArray();
        for(int i=0;i<k;i++){
            if(st.contains(arr[i])){
                ans++;
            }

        }
        fa=ans;
        for(int i=k;i<arr.length;i++){
            if(st.contains(arr[i-k])){
                ans--;
            }
            if(st.contains(arr[i])){
                ans++;
            }
            fa=Math.max(fa,ans);
        }
        return fa;
    }
}