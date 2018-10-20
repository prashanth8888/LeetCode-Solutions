class Solution {
    int sum = 0;
    
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0) return 0;
        helper(nums, target, 0);
        return sum;
    }
    
    public void helper(int[] candidates, int target, int start){
        
        if(target < 0) return;
        
        else if(target == 0){
            sum++;
            return;
            // tempList.clear();
        }
        
        for(int i = 0; i < candidates.length; i++){
            target -= candidates[i];
            helper(candidates, target, i);
            target += candidates[i];
        }
        
    }
}
