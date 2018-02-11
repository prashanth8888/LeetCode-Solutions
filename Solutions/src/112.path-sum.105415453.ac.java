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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        if(root == null)
                return false;
        
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            
            if(currentNode.left == null && currentNode.right == null && currentNode.val == sum)
                return true;
            
            if(currentNode.left != null){
                currentNode.left.val += currentNode.val;
                stack.push(currentNode.left);
            }
            
            if(currentNode.right != null){
                currentNode.right.val += currentNode.val;
                stack.push(currentNode.right);
            }
            
        }
        
        return false;

    }
}
