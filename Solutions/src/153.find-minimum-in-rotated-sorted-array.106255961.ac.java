public class Solution {
    public int findMin(int[] nums) {
     
        if(nums== null || nums.length == 0)
            return -1;
            
        int middle = 0, left = 0, right = nums.length - 1;
        
        //Not rotated - Left contains the least element
        if(nums[left] <= nums[right])
            return nums[left];
            
        while(left <= right){
            
            if(right - left == 1)
                return nums[right];
                
            middle = left + (right - left) / 2;
            if(nums[middle] > nums[right])
                left = middle;
            else
                right = middle;
        }
        return nums[left];
        
    }
}
