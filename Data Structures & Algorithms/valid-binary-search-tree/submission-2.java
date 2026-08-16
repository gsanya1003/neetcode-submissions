class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Long min, Long max) {
        if (node == null) {
            return true;
        }

        // Validate current node against upper and lower bounds set by ancestors
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Left subtree values must be < node.val (update max)
        // Right subtree values must be > node.val (update min)
        return helper(node.left, min, (long) node.val) && 
               helper(node.right, (long) node.val, max);
    }
}