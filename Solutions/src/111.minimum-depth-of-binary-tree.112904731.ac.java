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
    public int minDepth(TreeNode root) {
        
    if(root == null){
        return 0;
    }
    int ldepth = minDepth(root.left);
    int rdepth = minDepth(root.right);
    if(ldepth == 0){
        return 1+rdepth;
    }else if(rdepth == 0){
        return 1+ldepth;
    }

    return (1 + Math.min(rdepth, ldepth));
    }
}
