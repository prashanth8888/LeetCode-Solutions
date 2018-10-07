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

    private static Map<Integer, List<TreeNode>> cache = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int N) {
        
        List<TreeNode> result = new ArrayList<>();
        
        if(cache.containsKey(N)) return cache.get(N);
        
        if(N%2 == 0) return result;
        
        if(N == 1) {
            TreeNode node = new TreeNode(0);
            result.add(node);
            return result;
        }
        
        for(int i = 1; i < N-1; i+= 2){
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(N - i - 1);
            for(TreeNode leftNode : leftNodes){
                for(TreeNode rightNode : rightNodes){
                    TreeNode currNode = new TreeNode(0);
                    currNode.left = leftNode;
                    currNode.right = rightNode;
                    result.add(currNode);
                }
            }
        }
        
        cache.put(N, result);
        
        return result;

    }
    
}
