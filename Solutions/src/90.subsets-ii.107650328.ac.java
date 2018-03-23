public class Solution {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        if(nums == null)
            return resultList;
        
        subsetGenerator(resultList, new ArrayList<Integer>(), nums, 0);
        return resultList;
    }
    
    public void subsetGenerator(List<List<Integer>> resultList, List<Integer> subset, int[] nums, int start){
        resultList.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            subsetGenerator(resultList, subset, nums, i +1);
            subset.remove(subset.size() - 1);
        }
    }
}
