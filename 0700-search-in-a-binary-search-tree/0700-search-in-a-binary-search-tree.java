class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
         if (root == null || root.val == val) {
            return root;
        }

        // If the value is smaller, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the value is greater, search in the right subtree
        return searchBST(root.right, val);
    }
}