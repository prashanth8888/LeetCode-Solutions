public class Solution {
    public void sortColors(int[] nums) {
        
        int[] map = new int[3];
        for(int i = 0; i < nums.length; i++){
            map[nums[i]]++;
        }

        
        int pointer = 0;
        for(int j = 0; j < map.length; j++){
            while(map[j] > 0){
                nums[pointer++] = j;
                map[j] = map[j] - 1;
            }
            
        }
    }
}
