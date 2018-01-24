public class Solution {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        if(len == 1)
            return 0;
        
        int left = 0, right = nums.length - 1;
        
        while(right - left > 1){
             int mid = left + (right - left) / 2;
             if(nums[mid] < nums[mid+1])
                 left = mid + 1;
             else
                 right = mid;
        }
        
        return (left == len - 1 || nums[left] > nums[left + 1]) ? left : right; 
    }
}
