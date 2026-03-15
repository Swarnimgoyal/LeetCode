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
    int m=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return m;
    }
    public  int dfs(TreeNode root){
        if(root==null)return 0;
        int left=Math.max(dfs(root.left),0);
        int right=Math.max(dfs(root.right),0);
        int curr=root.val+left+right;
        m=Math.max(m,curr);
        return root.val+Math.max(left,right);
    }
}