class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();
        
        int ptr1 = 0, ptr2 = 0;
        char prevNameChar = nameArr[0];
        
        while(ptr1 < nameArr.length || ptr2 < typedArr.length){
            
            // System.out.println("Ptr1 " + ptr1 + "Ptr2 " + ptr2 + ": " +nameArr[ptr1] + " : " + typedArr[ptr2]  );
            
            if(ptr1 >= nameArr.length && typedArr[ptr2] == prevNameChar) ptr1 = nameArr.length - 1;
            
            if(ptr2 >= typedArr.length && ptr1 < nameArr.length) return false;
            
            if(nameArr[ptr1] != typedArr[ptr2]) return false;
            
            prevNameChar = nameArr[ptr1];
            
            if(ptr1 + 1 < nameArr.length && nameArr[ptr1+1] == nameArr[ptr1]){
                ptr1++;
                ptr2++;
                continue;
            }
            
            else if(ptr2 + 1 < typedArr.length && typedArr[ptr2+1] == typedArr[ptr2]){
                ptr2++;
                while(ptr2 < typedArr.length && typedArr[ptr2] == typedArr[ptr2-1]){
                    ptr2++;
                }
                ptr1++;
                continue;
            }
            
            else{
                ptr1++;
                ptr2++;
            }
            
        }
        
        return true;
    }
}
