class Solution {
    
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) return new ArrayList<List<Integer>>();
        combinationSumHelper(k, 1, n, new ArrayList<>());
        return result;
    }
    
    public void combinationSumHelper(int limit, int start, int target, List<Integer> tempResult) {
        
        if(tempResult.size() > limit || target < 0){
            return;
        }
        // System.out.println("Start " + start  + "Target " + target + "Temp Result "+ tempResult.toString());
        if(target == 0 && tempResult.size() == limit) {
           result.add(new ArrayList<>(tempResult));
        }
        
        
        
        for(int i = start; i < 10; i++) {
                        
            tempResult.add(i);
            combinationSumHelper(limit, i+1, target-i, tempResult);
            tempResult.remove(tempResult.size()-1);
            
        }
        
    }
}
