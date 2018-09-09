public class Solution {
    public String reverseWords(String s) {
         if (s == null) return null;
        
        int i = 0, j = s.length();
        char[] str = s.toCharArray();
        
        reverse(i, j-1, str); //Reverses the whole string
        reverseWords(j, str); //Reverses each and every word
        return cleanUpSpaces(j, str);
        
    }
    
    public void reverseWords(int j, char[] str){
        // System.out.println("After Conversion " + new String(str));
        int ptr1 = 0, ptr2 = 0;
        while(ptr2 < j){
            while(ptr1 < ptr2 || ptr1 < j && str[ptr1] == ' ') ptr1++;
            while(ptr2 < ptr1 || ptr2 < j && str[ptr2] != ' ') ptr2++;
            reverse(ptr1, ptr2 - 1, str);
        }
    }
    
    public String cleanUpSpaces(int limit, char[] str){
        int ptr1 = 0, ptr = 0;
        
        while(ptr1 < limit){
            while(ptr1 < limit && str[ptr1] == ' ') ptr1++;
            while(ptr1 < limit && str[ptr1] != ' ') str[ptr++] = str[ptr1++];
            while(ptr1 < limit && str[ptr1] == ' ') ptr1++;
            if(ptr1 < limit) str[ptr++] = ' '; //Except the last character
        }

        
        return new String(str).substring(0,ptr);
    }
    
    public void reverse(int i, int j, char[] str){
        while(i < j){
            char temp = str[i];
            str[i++] = str[j];
            str[j--] = temp;
        }
    }

}
