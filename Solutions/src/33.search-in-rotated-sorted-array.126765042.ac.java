class Solution {
    public int search(int[] nums, int target) {
        
        
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int start = 0, end = nums.length - 1, mid = 0;
        int num = 0;
        
        while(start < end){
            
            mid = start + (end-start) / 2;
            if(nums[mid] == target) return mid;
            
            //Left-part is sorted
            if(nums[start] <= nums[mid]){
                //Check within that range
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else 
                    start = mid + 1;
            }
            
            //Right part is assumed to be sorted
            else{
                
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            
        }
        
        return nums[start] == target ? start : -1;
        
    }
}
