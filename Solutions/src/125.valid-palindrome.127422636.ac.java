public class Solution {
    public boolean isPalindrome(String s) {
       if(s.equals("")) return true;
       if(s == null || s.length() == 0) return false;
       if(s.length() < 2) return true;
       
       s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
       int length = s.length();
       for(int i = 0; i < length / 2; i++){
           if(s.charAt(i) != s.charAt(length - 1 - i)) return false;
       }
       return true;
    }
}
