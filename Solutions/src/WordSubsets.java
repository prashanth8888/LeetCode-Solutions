class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        
        List<String> resultList = new ArrayList<>();
        //Get the character counts from the String 'B'
        int[] maxOccurenceCount = new int[256];
        
                
        for(String b : B) {
            int[] currOccurenceCount = new int[256];
            for(char c : b.toCharArray()){
                currOccurenceCount[c]++;
                maxOccurenceCount[c] = Math.max(maxOccurenceCount[c], currOccurenceCount[c]);
            }
        }

        
        for(String a : A) {
            int[] currOccurenceCount = new int[256];
            for(char c : a.toCharArray()){
                currOccurenceCount[c]++;
            }
            
            if(wordContains(currOccurenceCount, maxOccurenceCount))
                resultList.add(a);
        }
        
        return resultList;
        
    }
    
    private boolean wordContains(int[] currOccurenceCount, int[] maxOccurenceCount){
        
        for(int i = 0; i < maxOccurenceCount.length; i++){
            if(currOccurenceCount[i] < maxOccurenceCount[i])
                return false;
        }
        
        return true;
    }
}
