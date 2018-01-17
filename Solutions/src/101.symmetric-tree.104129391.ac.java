/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
    public boolean checkSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false; //Tree is not balanced
        return (left.val == right.val) && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}
