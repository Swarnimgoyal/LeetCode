class Solution {
    Queue<Integer> q=new LinkedList<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int orig=image[sr][sc];
        if(orig==color)return image;

        boolean [][] seen=new boolean[n][m];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc});
        seen[sr][sc]=true;
        image[sr][sc]=color;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
             int[] curr=q.poll();
             int r=curr[0], c=curr[1];
             for(int[] d:dirs){
                int nr=r+d[0], nc=c+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==orig){
                        image[nr][nc]=color;
                        q.addLast(new int[]{nr,nc});

                }
             }
        }
        return image;
    }
    
}