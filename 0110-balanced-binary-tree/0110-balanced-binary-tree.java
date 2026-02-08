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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int check(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }

        // Check the height of left subtree
        int leftHeight = check(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced

        // Check the height of right subtree
        int rightHeight = check(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced
        }

        // Return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return check(root) != -1; // If check returns -1, it's not balanced
    }
}
