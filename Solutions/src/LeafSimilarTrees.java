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
    private List<Integer> leafNodesOfTree = new ArrayList<>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        getLeafNodeValues(root1);
        List<Integer> leadNodesOfFirstTree = new ArrayList<>(leafNodesOfTree);
        
        leafNodesOfTree.clear();
        
        getLeafNodeValues(root2);
        List<Integer> leadNodesOfSecondTree = new ArrayList<>(leafNodesOfTree);
        
        if(leadNodesOfFirstTree.size() != leadNodesOfSecondTree.size()) return false;
        
        for(int i = 0; i < leadNodesOfFirstTree.size() ; i++){
            if(leadNodesOfFirstTree.get(i) != leadNodesOfSecondTree.get(i)) return false;
        }
        
        return true;
    }
    
    public void getLeafNodeValues(TreeNode node) {
        
        if(node == null) return;
        
        if(node.left == null && node.right == null){
            leafNodesOfTree.add(node.val);
        }
        
        getLeafNodeValues(node.left);
        getLeafNodeValues(node.right);
        
    }
}
