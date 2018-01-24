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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        
        if(root == null)
            return resultList;
        
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        
        while(!nodeQueue.isEmpty()){
            //System.out.println("In Here!");
            int size = nodeQueue.size();
            List<Integer> currentLevelList = new ArrayList<Integer>();
            for(int i =0; i < size; i++){
                
                if(nodeQueue.peek().left != null)
                    nodeQueue.add(nodeQueue.peek().left);
                if(nodeQueue.peek().right != null)
                    nodeQueue.add(nodeQueue.peek().right);
                
                currentLevelList.add(nodeQueue.poll().val);    
            }
            resultList.add(currentLevelList);
        }
        
        return resultList;
        
    }
}
