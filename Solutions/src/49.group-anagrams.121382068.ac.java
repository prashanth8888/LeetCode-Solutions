class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        List<List<String>> resultList = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
        
            char[] currString = strs[i].toCharArray();
            Arrays.sort(currString);
            String tempString = String.valueOf(currString);
            
            if(map.containsKey(tempString)){
                List<String> tempList = map.get(tempString);
                tempList.add(strs[i]);
                map.put(tempString, tempList);
            }
            else{
                
                map.put(tempString, new ArrayList<String>());
                List<String> tempList = map.get(tempString);
                tempList.add(strs[i]);
                map.put(tempString, tempList);
            }
                
        }
        
        return new ArrayList<List<String>>(map.values());
        
        
    }
}
