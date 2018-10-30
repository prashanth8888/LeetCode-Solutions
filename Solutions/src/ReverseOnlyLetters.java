class Solution {
    public String reverseOnlyLetters(String S) {
        if(S == null || S.isEmpty()) return S;
        char[] charArray = S.toCharArray();
        int ptr1 = 0, ptr2 = S.length() - 1;
        
        while(ptr1 < ptr2) {
            
            if(!Character.isLetter(charArray[ptr1])){
                while(ptr1 < ptr2 && !Character.isLetter(charArray[ptr1])){
                    ptr1++;
                }
            }
            
            if(!Character.isLetter(charArray[ptr2])){
                while(ptr2 > ptr1 && !Character.isLetter(charArray[ptr2])){
                    ptr2--;
                }
            }
            
            if(!Character.isLetter(charArray[ptr1]) || !Character.isLetter(charArray[ptr2])){
                ptr1++;
                ptr2--;
                continue;
            }
            
            if( ptr1 < ptr2){
                char temp = charArray[ptr1];
                charArray[ptr1] = charArray[ptr2];
                charArray[ptr2] = temp;
            }
            
            ptr1++;
            ptr2--;
            
        }
        
        return new String(charArray);
        
    }
}
