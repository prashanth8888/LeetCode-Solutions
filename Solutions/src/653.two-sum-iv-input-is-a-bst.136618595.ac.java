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
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;
        
        if(root.left == null && root.right == null) return false;
        
        return traverseTree(root, root, k);
        
    }
    
    public boolean traverseTree(TreeNode node, TreeNode root, int target){
        
        if(node == null) return false;
        
        if(searchNode(node, root, target - node.val)) return true;
        
        return traverseTree(node.left, root, target) || traverseTree(node.right, root, target);
        
    }
    
    public boolean searchNode(TreeNode excludeNode, TreeNode root, int target){
        
        if(root == null) return false;
        
        if(root.val == target)
            return root != excludeNode;
        
        else if(target > root.val)
            return searchNode(excludeNode, root.right, target);
        
        else if(target < root.val)
            return searchNode(excludeNode, root.left, target);
        
        return false;
        
    }
}
