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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        
        while(!queue1.isEmpty() && !queue2.isEmpty() && (queue1.size() == queue2.size()) ){
            
            TreeNode currNode1;
            TreeNode currNode2;
            
            int size = queue1.size(); //Can be either of the queues;
            
            for(int i = 0; i < size; i++){
                currNode1 = queue1.poll();
                currNode2 = queue2.poll();
                
        // System.out.println("Current Node values " + "Node1:" + currNode1.val + "Node2:" + currNode2.val);
                if(currNode1 == null && currNode2 == null) continue;
                if(currNode1 == null || currNode2 == null) return false;
                if(currNode1.val != currNode2.val)         return false;
                
                queue1.offer(currNode1.left);
                queue1.offer(currNode1.right);
                queue2.offer(currNode2.left);
                queue2.offer(currNode2.right);
            }
               
        }
        
        return queue1.size() == queue2.size();
    }
}
