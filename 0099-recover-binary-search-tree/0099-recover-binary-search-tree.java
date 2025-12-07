import java.util.ArrayList;
import java.util.List;

class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        
        // Step 1: fill inorder list of nodes
        inorder(root, inorderList);
        
        // Step 2: find two misplaced nodes
        TreeNode first = null;
        TreeNode second = null;
        
        for (int i = 0; i < inorderList.size() - 1; i++) {
            if (inorderList.get(i).val > inorderList.get(i + 1).val) {
                if (first == null) {
                    // first violation
                    first = inorderList.get(i);
                    second = inorderList.get(i + 1);
                } else {
                    // second violation
                    second = inorderList.get(i + 1);
                    break;
                }
            }
        }
        
        // Step 3: swap their values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}

