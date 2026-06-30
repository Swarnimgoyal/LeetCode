class Solution {
    public int numberOfSubstrings(String s) {
        int a=-1;
        int b=-1;
        int c=-1;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                a=i;
            }
            else if(s.charAt(i)=='b'){
                b=i;
            }else if(s.charAt(i)=='c'){
                c=i;
            }
             cnt+=Math.min(Math.min(a,b),c)+1;

        }
        return cnt;
    }
}