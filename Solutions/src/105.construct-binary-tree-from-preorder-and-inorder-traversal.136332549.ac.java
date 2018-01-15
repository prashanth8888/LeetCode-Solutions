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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return constructTree(0, 0, inorder.length - 1 ,preorder, inorder, map);
    }
    
    public TreeNode constructTree(int preOrderStart, int inorderStart, int inorderEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> map){
        
        if(preOrderStart >= preorder.length || inorderStart > inorderEnd) return null;
        
        TreeNode node = new TreeNode(preorder[preOrderStart]);
        int inorderIndex = map.get(preorder[preOrderStart]);
        int leftSubTreeLength = inorderIndex - inorderStart;
        
        node.left = constructTree(preOrderStart+1, inorderStart, inorderIndex-1, preorder, inorder, map); 
        node.right = constructTree(preOrderStart+ leftSubTreeLength + 1, inorderIndex + 1, inorderEnd, preorder, inorder, map);
        
        return node;
    }
}
