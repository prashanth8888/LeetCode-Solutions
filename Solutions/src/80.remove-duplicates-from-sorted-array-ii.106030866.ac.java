public class Solution {
    public int removeDuplicates(int[] nums) {
        
        int indextobePlaced = 1;
        int lengthofNonDuplicateArray = 1;
        
        int curr = 0;
        boolean secondDuplicate = false;
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int prev = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            
            curr = nums[i];
            if(curr == prev){
                if(!secondDuplicate){
                    secondDuplicate = true;
                    nums[indextobePlaced++] = curr;
                    lengthofNonDuplicateArray++;
                }
            }
            else{
                prev = curr;
                nums[indextobePlaced++] = curr;
                secondDuplicate = false;
                lengthofNonDuplicateArray++;
            }
        }
        
        return lengthofNonDuplicateArray;
        
        
    }
}
