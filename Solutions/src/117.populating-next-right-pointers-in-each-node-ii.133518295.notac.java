/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if(root == null || (root.left == null && root.right == null)) return;
        
        while(root != null){
            
            TreeLinkNode tempNode = root;
            TreeLinkNode matchingNode = null;
            TreeLinkNode nextMatchingNode = null;
            
            while(tempNode != null){
                
                // TreeLinkNode matchingNode = null;
                
                
                if(tempNode.left != null){
                    matchingNode = tempNode.left;
                }
                
                if(tempNode.right != null){
                    if(tempNode.left != null)
                        tempNode.left.next = tempNode.right;
                    matchingNode = tempNode.right;
                }
            
                if(tempNode.next != null){
                    if(tempNode.next.left != null) nextMatchingNode = tempNode.next.left;
                    if(tempNode.next.right != null) nextMatchingNode = tempNode.next.right;
                }
                
                if(matchingNode != null && nextMatchingNode != null)
                    matchingNode.next = nextMatchingNode;
                                
                tempNode = tempNode.next;
            }
            
            root = root.left;
        }
        
    }
}
