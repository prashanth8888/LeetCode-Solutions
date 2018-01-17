public class Solution {
    int[] result = {-1,-1};
    public int[] searchRange(int[] nums, int target) {
       
       if(nums == null || nums.length == 0)
            return result;
       int left = 0, right = nums.length - 1;
       binarySearch(nums, left, right, target);
       return result;
    }
    
    public void binarySearch(int[] nums, int left, int right, int target){
        
        if(left > right) return;
        //Binary search is done and interval is reduced between left and right such a way that they are adjacent to each other.
        if(nums[left] == nums[right] && nums[left] == target){
            result[0] = left;
            result[1] = right;
            return;
        }
        
        
        int middle = left + (right - left) / 2;
        if(nums[middle] < target){
            binarySearch(nums, middle+1, right, target);
        }
        else if(nums[middle] > target){
            binarySearch(nums, left , middle-1, target);
        }
        else{
            result[0] = middle;
            result[1] = middle;
            
            int t1 = middle;
            while(t1 > left && nums[t1] == nums[t1 - 1]){
                t1--;                
                result[0] = t1;
            }
            
            int t2 = middle;
            while(t2 < right && nums[t2] == nums[t2 + 1]){
                t2++;
                result[1] = t2;
            }
            return;
        }
        
    }
}
