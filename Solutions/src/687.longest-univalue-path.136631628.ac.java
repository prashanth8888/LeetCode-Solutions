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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }
    
    //DFS based approach - Tracks the path from bottom up
    public int dfs(TreeNode root, int[] val){
        int l = root.left == null ? 0 : dfs(root.left, val);
        int r = root.right == null ? 0 : dfs(root.right, val);
        
        int resl = root.left != null && root.left.val == root.val ? l + 1 : 0;
        int resr = root.right != null && root.right.val == root.val ? r + 1 : 0;
        
        // System.out.println("Current Node " + root.val + " " +  resl + " " + resr);
        
        val[0] = Math.max(val[0], resl + resr);
        return Math.max(resl, resr);
        
        
    }
}
