public class Solution {
    public int searchInsert(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        
        while( i <= j){
            
            mid = (i+j)/2;
            
            if(nums[mid] < target)
                i = mid + 1;
            else if(nums[mid] > target)
                j = mid - 1;
            else 
                return mid;
        }
        return i;
    }
}
