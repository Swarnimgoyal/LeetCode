class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int b=bloomDay.length;
        if(b<m*k)return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        int ans=-1;
        for(int n:bloomDay){
            low=Math.min(n,low);
            high=Math.max(n,high);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(can(bloomDay,m,k,mid)){
                high=mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }

        }
        return ans;
    }
    public boolean can(int [] bloomDay,int m,int k,int d){
        int flower=0;
        int bokey=0;
        for(int n:bloomDay){
            if(n<=d){
                flower++;
                if(flower==k){
                    bokey++;
                    flower=0;
                }

            }else{
                flower=0;
            }
        }
        if(bokey>=m)return true;
        return false;
    }
}