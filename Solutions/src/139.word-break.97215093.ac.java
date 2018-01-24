public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        StringBuilder compareString = new StringBuilder(); 
        int rangeofSubstring = 0;
        //String currentDicWord = wordDictIterator.next();
        for(int i = 0; i < s.length(); i++){
            compareString.append(s.charAt(i));
            //System.out.println("CompareString " + compareString.toString());
            if(wordDict.contains(compareString.toString())) {
            	 rangeofSubstring += compareString.length();
                 compareString.setLength(0);
                }
            }
        //System.out.println("No of Comparasions " + countofComparasions);
        //System.out.println("Size of Dict" + wordDict.size());
        if(rangeofSubstring == s.length()) return true;
        else return false;
        */
        boolean[] intermediateFlags = new boolean[s.length() + 1];
        intermediateFlags[0] = true;
        for(int i=1; i <= s.length(); i++)
            for(int j=0; j < i; j++){
                if(intermediateFlags[j] && wordDict.contains(s.substring(j, i))){
                    intermediateFlags[i] = true;
                    break; // Breaks the inner for loop
                }
            }
        return intermediateFlags[s.length()];
        }
        
    }

