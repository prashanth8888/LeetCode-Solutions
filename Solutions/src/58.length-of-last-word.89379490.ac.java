public class Solution {
    public int lengthOfLastWord(String s) {
        int lengthofLastWord = 0;
        if(s.length() == 0) return 0;
        String[] splitString = s.trim().split(" "); 
        lengthofLastWord = splitString[splitString.length-1].length();
        return lengthofLastWord;
    }
}
