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
    
    int maxDepth = -1; 
    TreeNode result = new TreeNode(0); 
		
    public TreeNode subtreeWithAllDeepest (TreeNode root) {
        if(root == null)
            return root; 
        result = null;  
        getNode(root , 0); 
        return result; 
    }
    
    public int getNode (TreeNode root, int depth){
        if(root == null)
            return depth; 
        int l = getNode(root.left, depth+1); 
        int r = getNode(root.right, depth+1); 

        if(l == r && l >= maxDepth){
            maxDepth = l; 
            result = root; 
        }
				
        return Math.max(l,r);
    }
    
}
