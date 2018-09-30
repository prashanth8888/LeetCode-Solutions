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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        
        TreeNode preNode = new TreeNode(0);
        preNode.right = root;
        increasingBSThelper(root, preNode);
        
        return preNode.right;
    }
    
    public TreeNode increasingBSThelper(TreeNode root, TreeNode pre){
        if(root == null) return pre;
        
        TreeNode currPrev = increasingBSThelper(root.left, pre);
        currPrev.right = root;
        root.left = null;
        
        return increasingBSThelper(root.right, root);
    }
}
