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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)return res;
       Queue <TreeNode> q= new LinkedList<>();
       q.offer(root);
       while(!q.isEmpty()){
        int se=q.size();
        for(int i=0;i<se;i++){
            TreeNode n=q.poll();
            if(i==se-1){
                res.add(n.val);
            }
            if(n.left!=null) q.offer(n.left);
            if(n.right!=null)q.offer(n.right);

        }
       }

        return res;

    }
}