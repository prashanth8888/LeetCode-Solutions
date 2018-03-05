class Solution {
    public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        
        int size = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for(int i = 0; i <= size; i++){
            
            int tempHeight = i == size ? 0 : heights[i];
            //Keep pushing the indexes for the increasing heights 
            if(stack.isEmpty() || heights[stack.peek()] <= tempHeight){
                stack.push(i);
            }
            //Calculate the Areas
            else{
                       
                    int top = heights[stack.pop()];
                    
                    if(stack.isEmpty())
                        maxArea = Math.max(maxArea, (i * top));
                    else
                        maxArea = Math.max(maxArea, (top * (i - stack.peek() - 1)));  
                    i--;
            }//end-else
        }//end-for
    
        
        return maxArea;
        
    }
}
