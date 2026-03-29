class Solution {
    public boolean canBeEqual(String s1, String s2) {
        for(int i=0;i<4;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(i==0||i==2){
                    if(s1.charAt(0)==s2.charAt(2)&&s2.charAt(0)==s1.charAt(2)){
                    continue;
                    }
                    else{
                        return false;
                    }
                }
                if(i==1||i==3){
                    if(s1.charAt(1)==s2.charAt(3)&&s2.charAt(1)==s1.charAt(3)){
                    continue;}
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}