class Solution {
    public int myAtoi(String str) {
    
        if(str == null) return -1;
        if(str.length() == 0) return 0;
        
        
        
        
        str = str.trim();
        int size = str.length();
        long sum = 0;
        
        String res = "";
        if(str.charAt(0) == '+') res = "+";
        else if(str.charAt(0) == '-') res = "-";
        
        
        char[] charArray = str.toCharArray();
        
        for(int i = 0; i < size; i++){
            
            if(Character.isDigit(charArray[i])){
                sum = (charArray[i] - '0') + sum * 10;
                // System.out.println(sum);
                if(res.equals("+") && sum > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if(res.equals("-") && sum > Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;
                else if(sum > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
            else if(i == 0 && (charArray[i] != '+' && charArray[i]  != '-')) return 0;
            
            else if(i > 0 && (charArray[i]  == '+' || charArray[i]  == '-')) return 0;
            
            else if(i > 0) break;
            
        }
        
        if(sum == 0 && res.equals("+") || sum == 0 && res.equals("-")) return 0; 
        if(res.equals("-")) sum = -(sum);
        
        return sum == 0 ? 0 : (int)sum;
    }
}
