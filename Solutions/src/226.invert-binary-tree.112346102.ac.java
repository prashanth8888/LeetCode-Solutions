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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return null;
            
        // Stack<TreeNode> pushedNodes = new Stack<TreeNode>();
        // pushedNodes.push(root);
        Queue<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.offer(root);
        TreeNode temp;
        
        while(!queueNodes.isEmpty()){
            int size = queueNodes.size();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queueNodes.poll();
                temp = node.left;
                node.left = node.right;
                node.right = temp;
                if(node.left != null)
                    queueNodes.offer(node.left);
                if(node.right != null)
                    queueNodes.offer(node.right); 
            }
            
            // TreeNode node = pushedNodes.pop();
            // temp = node.left;
            // node.left = node.right;
            // node.right = temp;
            
            // if(node.left != null)
            //     pushedNodes.push(node.left);
            // if(node.right != null)
            //     pushedNodes.push(node.right);
            
        }
        
        return root;
    }
}
