class Solution {
    char[] string;
    
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] primeNos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127};
        
        if(p.length() > s.length()) return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> charMap = new HashMap<>();
        
        for(int i = 0; i < 26; i++){
            charMap.put(i, i+1);
        }
        
        int k = p.length();
        int n = s.length();
        
        int substringSum = 0;
        int currentSum = 0;
        
        for(int j = 0; j < k; j++){
            
            substringSum +=  (charMap.get(p.charAt(j) - 'a') * primeNos[p.charAt(j) - 'a']);   
        }
        
        for(int m = 0; m < k; m++){
            currentSum += (charMap.get(s.charAt(m) - 'a') * primeNos[s.charAt(m) - 'a']);   
        }
        
        if(currentSum == substringSum) result.add(0); //first position
        
        for(int l = k; l < n; l++){
            currentSum = currentSum - (charMap.get(s.charAt(l-k) - 'a') * primeNos[s.charAt(l-k) - 'a']) + (charMap.get(s.charAt(l) - 'a') *                 primeNos[s.charAt(l) - 'a']);
            if(currentSum == substringSum) result.add(l-k+1);
        }
        
        return result;
    }
    
}
