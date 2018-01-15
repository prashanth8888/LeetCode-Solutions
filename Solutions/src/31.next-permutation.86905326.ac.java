public class Solution {
    
    public void nextPermutation(int[] nums) {
    if(nums == null || nums.length == 1) return;
		
		int index1 = 0;
		int index2 = 0;
		
		for(int i=nums.length-1;i>0;i--){
			if(nums[i-1] < nums[i]){
				System.out.println("First Loop Break at " + i);
				index1 = i-1;
				break;
			}
		}
		
		for(int j=nums.length-1;j>index1; j--){
			if(nums[j] > nums[index1]){
				System.out.println("Second Loop Break at " + j);
				index2 = j;
				break;
			}
		}
		
		if(index1 == 0 && index2 == 0){
			Arrays.sort(nums);
			/*
			System.out.println("Printing the Array after the Permutation: ");
			for(int n: nums){
				System.out.print(" " + n);
			}*/
			return;
		}
		
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
		
		if(index1 < nums.length -1){
			//Need to Reverse the list to arrange in Lexicographical order
			reverse_array(nums,index1+1,nums.length-1);
		}
		
		/*
		System.out.println("Printing the Array after the Permutation: ");
		for(int n: nums){
			System.out.print(" " + n);
		}*/
    }
    
    public void reverse_array(int[] nums, int lidx, int ridx){
		while(lidx < ridx){
			int temp = nums[lidx];
			nums[lidx] = nums[ridx];
			nums[ridx] = temp;
			lidx++;
			ridx--;
		}
    }
		
}
