class Solution {
    public void setZeroes(int[][] matrix) {
    Set<Integer> r=new HashSet<>();
    Set<Integer> c=new HashSet<>();
    int n=matrix.length;
    int m=matrix[0].length;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(matrix[i][j]==0){
                r.add(i);
                c.add(j);
            }

        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(r.contains(i)||c.contains(j)){
                matrix[i][j]=0;
            }
        }
    }
    return ;
        
    }
}