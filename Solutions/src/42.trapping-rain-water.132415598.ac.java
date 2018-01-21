class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0) return 0;
        
        int size = height.length;
        int sum = 0;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        
        leftMax[0] = height[0];
        
        for(int i = 1; i < size; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        
        rightMax[size - 1] = height[size - 1];
        for(int j = size - 2; j >= 0; j--){
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }
        
        
        
        for(int k = 0; k < size; k++){
            sum += (Math.min(leftMax[k], rightMax[k]) - height[k]);
        }
        
        return sum;
    }
}
