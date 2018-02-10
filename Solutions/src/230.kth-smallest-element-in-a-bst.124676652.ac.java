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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        if(root == null) return 0;
        
        Stack<TreeNode> stack = new Stack<>();
        traverseLeft(root, stack);
        
        while(!stack.isEmpty()){
            
                TreeNode node = stack.pop();
                if(++count == k) return node.val;
                if(node.right != null)
                    traverseLeft(node.right, stack);
                    
        }
        
        return Integer.MIN_VALUE;
        
    }
    
    public void traverseLeft(TreeNode node, Stack stack){
        
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
