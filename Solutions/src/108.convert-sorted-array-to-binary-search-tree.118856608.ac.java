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
    
    public TreeNode sortedArrayToBST(int[] nums) {
       	if(nums.length == 0) return null;
		// int mid = nums.length / 2;
		// TreeNode root = new TreeNode(nums[mid]);
		// root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
		// root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
		// return root;
        TreeNode resultNode = helper(nums, 0, nums.length - 1);
        return resultNode;
    }
    
    public TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;
        
        TreeNode newNode;
        
        if(left == right){
            newNode = new TreeNode(nums[left]);
            newNode.left = null;
            newNode.right = null;
        }
        else{
            int mid = left + (right - left) / 2;
            newNode = new TreeNode(nums[mid]);
            newNode.left  = helper(nums, left, mid - 1);
            newNode.right = helper(nums, mid+1, right);
        }
        
        return newNode;
    }
}
