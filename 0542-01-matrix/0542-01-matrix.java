class Solution {
    public static final int [][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int n =mat.length;
        if(n==0)
        return mat;
        int m=mat[0].length;
        int [][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=-1;
            }
        }

        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    q.addLast(new int []{i,j});

                }
            }
        }
        while(!q.isEmpty()){
                int[] curr=q.removeFirst();
                int r=curr[0],c=curr[1];
                int d=dist[r][c];
                for(int []dir:dirs){
                    int nr=r+dir[0],nc=c+dir[1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && dist[nr][nc]==-1){
                        dist[nr][nc]=d+1;
                        q.addLast(new int[]{nr,nc});

                    }
                }
        }
        return dist;
    }
}