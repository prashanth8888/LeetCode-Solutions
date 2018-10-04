class Solution {
    public boolean canPartition(int[] nums) {
        
        if(nums == null || nums.length == 0 || nums.length == 1) return false;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        if(sum % 2 != 0) return false; //Happens so that array can't be halved
        
        sum = sum / 2;
        boolean[][] result = new boolean[nums.length + 1][sum + 1];
        
        for(int i = 0; i < nums.length ; i++)
            result[i][0] = true;
        
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum ; j++){
                if(j - nums[i-1] >= 0)
                    result[i][j] = result[i-1][j] || result[i-1][j - nums[i-1]];
                else
                    result[i][j] = result[i-1][j];
            }
        }
        
        return result[nums.length][sum];
        
    }
}
