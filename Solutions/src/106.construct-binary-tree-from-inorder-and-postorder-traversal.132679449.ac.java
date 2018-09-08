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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return constructTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map); 
    }
    
    public TreeNode constructTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map){
        
        if(ps > pe || is > ie) return null;
        
        TreeNode node = new TreeNode(postorder[pe]);
        
        int pivot = map.get(postorder[pe]); //Gives the position of the root in inorder.
        
        node.left = constructTree(inorder, is, pivot - 1, postorder, ps, ps+pivot-is-1 , map );
        node.right = constructTree(inorder, pivot + 1, ie, postorder, ps+pivot-is , pe-1, map );
        
        return node;
    }
}
