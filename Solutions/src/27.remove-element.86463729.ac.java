public class Solution {
    public int removeElement(int[] nums, int val) {
        int updated_count = 0;
		int p1 = 0;
		for(int p2=0; p2<nums.length; p2++){
			if(nums[p2] != val){
				nums[p1] = nums[p2];
				p1++;
				//Update the Counter of New Array
				updated_count++;
			}
		}
		
		return updated_count;
    }
}
