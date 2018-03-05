public class Solution {
    
    List<List<Integer>> resultList = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if(nums == null)
            return resultList;
        
        generateSubset(resultList,new ArrayList<Integer>(), nums, 0);
        return resultList;
    }
    
    public void generateSubset(List<List<Integer>> resultList, List<Integer> subset, int[] nums, int start){
        
        resultList.add(new ArrayList<Integer>(subset));
        for(int i = start; i < nums.length ; i++){
            
            subset.add(nums[i]);
            generateSubset(resultList, subset, nums, i + 1);
            subset.remove(subset.size() - 1); //Removes the last elements and enables other combination to be calculated.
        }
        
    }
}
