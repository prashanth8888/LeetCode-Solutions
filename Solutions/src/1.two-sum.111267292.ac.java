public class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        HashMap<Integer, Integer> masterMap = new HashMap<>();
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(masterMap.containsKey(target - nums[i])){
                result[0] = masterMap.get(target - nums[i]);
                result[1] = i;
            }     
            else
                masterMap.put(nums[i], i);
        }
        
        return result;
    }
}
