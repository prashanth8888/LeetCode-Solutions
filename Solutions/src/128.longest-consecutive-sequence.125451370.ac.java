class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        SortedSet<Integer> set = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int num: nums){
            set.add(num);
        }
        
        for(int num: nums){
            
            if(set.remove(num)){
                
                int val = num;
                int sum = 1;
                
                while(set.remove(val-1)) val--;
                
                sum += num - val;
                
                val = num;
                while(set.remove(val+1)) val++;
                
                sum += val - num;
                
                max = Math.max(max, sum);
                
            }//end-if
        }//end-for
        
        return max;
    }
}
