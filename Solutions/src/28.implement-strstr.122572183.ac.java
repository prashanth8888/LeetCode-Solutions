public class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack.length() == 0 && needle.length() == 0) || (haystack.length() > 0 && needle.length() == 0))
            return 0;
        if(haystack.length() == 0 && needle.length() > 0)
            return -1;
        if(haystack.length() == needle.length()){
            if(haystack.equals(needle))
                return 0;
            else 
                return -1;
        }
        
        char[] haystackCharArray = haystack.toCharArray();
        char startCharofSubstring = needle.charAt(0);
        int result = -1;
        
        for(int i = 0; i < (haystackCharArray.length - needle.length()) +1 ; i++){
            if((haystackCharArray[i] == startCharofSubstring) && (haystack.substring(i, i+needle.length()).equals(needle))){
                result = i;
                break;
            }
            
        }
        return result;
        
    }
}
