/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>  q=new LinkedList<>();
        int m=root.val;
        int level=0;
        int ans=1;
        q.offer(root);

        while(!q.isEmpty()){
            int sum=0;
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode c=q.poll();

                sum+=c.val;
                if(c.left!=null)q.offer(c.left);
                if(c.right!=null)q.offer(c.right);

            }
            level++;

            if(m<sum){
                m=sum;
                ans=level;
            }
        }
        return ans;
    }
}