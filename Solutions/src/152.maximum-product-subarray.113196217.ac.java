public class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        int maxSoFar = 0, minSoFar = 0, max = nums[0];
        int maxHerePrev = nums[0], minHerePrev = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            maxSoFar = Math.max(Math.max(nums[i] * maxHerePrev, nums[i] * minHerePrev), nums[i]);
            minSoFar = Math.min(Math.min(nums[i] * maxHerePrev, nums[i] * minHerePrev), nums[i]);
            
            max = Math.max(max, maxSoFar);
            
            maxHerePrev = maxSoFar;
            minHerePrev = minSoFar;
             
        }
        
        return max;
    }
}
