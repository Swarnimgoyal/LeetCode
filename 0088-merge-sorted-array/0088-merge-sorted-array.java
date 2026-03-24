class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] res=new int[n+m];
        for(int i=0;i<m;i++){
            res[i]=nums1[i];
        }
        int k=m;
        for(int i=0;i<n;i++){
            res[k++]=nums2[i];
        }
        Arrays.sort(res);
        for(int i=0;i<n+m;i++){
            nums1[i]=res[i];
        }
        return ;
    }
}