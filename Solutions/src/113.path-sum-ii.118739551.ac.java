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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> currentResult = new LinkedList<>();
        helper(root, result, currentResult, sum);
        return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result, List<Integer> currentResult, int sum){
        if(root == null) return;
        
        currentResult.add(new Integer(root.val));
        
        if(root.left == null && root.right == null && root.val == sum){
            // System.out.println("Path condition" + root.val + ":" + sum);
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);
            return;
        }
        
        else{
                helper(root.left, result, currentResult, sum-root.val);
                helper(root.right, result, currentResult, sum-root.val);
                // currentResult.remove(currentResult.size() - 1);
        }
        
        currentResult.remove(currentResult.size() - 1);
    }
}
