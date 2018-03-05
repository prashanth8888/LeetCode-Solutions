class Solution {
    public String shortestPalindrome(String s) {
        
        int start = 0, tempEnd = s.length() - 1, end = tempEnd;
        char[] charArray = s.toCharArray();
        
        while(start < tempEnd){
            if(charArray[start] == charArray[tempEnd]){
                start++;
                tempEnd--;
            }
            else{
                start = 0; //Reset to the head - Try to find again
                end--;
                tempEnd = end;
            }
        }
        
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
        
    }
}
