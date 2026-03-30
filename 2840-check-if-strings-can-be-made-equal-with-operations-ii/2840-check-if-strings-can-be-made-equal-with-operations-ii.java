class Solution {
    public boolean checkStrings(String s1, String s2) {
        StringBuilder sb1odd = new StringBuilder();
        StringBuilder sb1even = new StringBuilder();
        StringBuilder sb2odd = new StringBuilder();
        StringBuilder sb2even = new StringBuilder();
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(i%2==0){
                sb1even.append(s1.charAt(i));
                sb2even.append(s2.charAt(i));
            }else{
                sb1odd.append(s1.charAt(i));
                sb2odd.append(s2.charAt(i));
            }
        }
       

        char[] arr1o = sb1odd.toString().toCharArray();
        Arrays.sort(arr1o);

        sb1odd = new StringBuilder(new String(arr1o));
       

        char[] arr2o = sb2odd.toString().toCharArray();
        Arrays.sort(arr2o);

        sb2odd = new StringBuilder(new String(arr2o));

         if(!sb1odd.toString().equals(sb2odd.toString())) return false;
         char[] arr1even = sb1even.toString().toCharArray();
        Arrays.sort(arr1even);

        sb1even = new StringBuilder(new String(arr1even));
       

        char[] arr2even = sb2even.toString().toCharArray();
        Arrays.sort(arr2even);

        sb2even = new StringBuilder(new String(arr2even));
        if(!sb1even.toString().equals(sb2even.toString())) return false;
        return true;
        
        
    }
}