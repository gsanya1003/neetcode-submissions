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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> list = new ArrayList<>();
        if(root==null)
        return list;
        Queue<TreeNode > q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < s; i++){
                TreeNode t = q.remove();
                if(t.left!=null)
                q.add(t.left);
                 if(t.right!=null)
                q.add(t.right);
                arr.add(t.val);


            }
            list.add(arr);
        }
        return list;
        
    }

    
}
