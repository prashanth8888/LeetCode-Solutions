/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        
        
        if(root == null)
            return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null; //Place it null to avoid in the next loop
        
        flatten(left);
        flatten(right);
        
        root.right = left;
        
        TreeNode currentRight = root;
        while(currentRight.right != null) currentRight = currentRight.right;
        
        currentRight.right = right;
        
        
    }
    
}
