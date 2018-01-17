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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        
        if(root == null)
            return resultList;
            
        Deque<TreeNode> elementsQueue = new LinkedList<>();
        elementsQueue.offer(root);
        int level = 0;
        TreeNode tempRoot = null;
        
        while(!elementsQueue.isEmpty()){
        int size = elementsQueue.size();
        List<Integer> tempList = new ArrayList<Integer>();
        
        for(int i = 0; i < size; i++){
            
            if(level % 2 == 0){
                //Traverse from left to right
                tempRoot = elementsQueue.peekFirst();
                tempList.add(elementsQueue.pollFirst().val);
                // System.out.println("Current Element " + tempRoot.val);
                if(tempRoot.left != null ) elementsQueue.offer(tempRoot.left);
                if(tempRoot.right != null ) elementsQueue.offer(tempRoot.right);
            }    
            else{
                //Traverse from right to left
                tempRoot = elementsQueue.peekLast();
                tempList.add(elementsQueue.pollLast().val);
                // System.out.println("Current Element " + tempRoot.val);
                if(tempRoot.right != null ) elementsQueue.offerFirst(tempRoot.right);
                if(tempRoot.left != null ) elementsQueue.offerFirst(tempRoot.left);
            }
        }
            resultList.add(tempList);
            level++; 

        }
        
        return resultList;
    }
}
