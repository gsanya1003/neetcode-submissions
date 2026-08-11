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
   
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
       
       if(root == null)
       return 0;
        arr[0]=root.val;
       sum(root, arr);
       return arr[0];

        
    }

    public int sum(TreeNode root, int arr[]){
         if(root == null)
        return 0;
        int left = Math.max(0,sum(root.left, arr));
        int right = Math.max(0,sum(root.right, arr));
        arr[0] = Math.max(arr[0], root.val + left+right);
        return root.val + Math.max(left, right);
        
    }
}
