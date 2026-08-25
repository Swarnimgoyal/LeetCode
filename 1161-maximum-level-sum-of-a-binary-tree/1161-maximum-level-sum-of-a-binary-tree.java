class Solution {
    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return -1;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1;
        int ans = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {

            int size = q.size();
            int sum = 0;

            for (int j = 0; j < size; j++) {

                TreeNode x = q.poll();

                sum += x.val;

                if (x.left != null) {
                    q.add(x.left);
                }

                if (x.right != null) {
                    q.add(x.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }

            level++;
        }

        return ans;
    }
}