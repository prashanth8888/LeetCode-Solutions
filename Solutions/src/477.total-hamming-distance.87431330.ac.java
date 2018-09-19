public class Solution {
    public int totalHammingDistance(int[] nums) {
         int totalHammingDistance = 0;
		 for(int i=0; i<nums.length-1; i++){
			 for(int j=i+1; j< nums.length; j++){
				 totalHammingDistance += (Integer.bitCount(nums[i] ^ nums[j])); 
			 }
		 }
	     return totalHammingDistance;
    }
}
