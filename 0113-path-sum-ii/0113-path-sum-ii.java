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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        helper(root, targetSum, new ArrayList<>());
        return res;
    }

    private void helper(TreeNode node, int targetSum, List<Integer> curr_list) {
        if (node == null) return;

        curr_list.add(node.val);

        // if it's a leaf and the sum matches, store the path
        if (node.left == null && node.right == null && node.val == targetSum) {
            res.add(new ArrayList<>(curr_list));
        } else {
            // explore both sides
            helper(node.left, targetSum - node.val, curr_list);
            helper(node.right, targetSum - node.val, curr_list);
        }

        // backtrack
        curr_list.remove(curr_list.size() - 1);
    }
}
