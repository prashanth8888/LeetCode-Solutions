class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() < t.length()) return "";
        
        int[] needCharMap = new int[256];
        int[] stringMap = new int[256];
        int optBegin = 0, optEnd = 0;
        int begin = 0, end = 0, count = 0;
        
        int optLen = Integer.MAX_VALUE;
        boolean subStringExists = false;
        
        for(int i = 0; i < t.length(); i++){
            needCharMap[t.charAt(i)]++;
        }
        
        char[] stringArray = s.toCharArray();
        for(end = 0; end < stringArray.length; end++){
            if(needCharMap[stringArray[end]] == 0) continue;
            else{
                stringMap[stringArray[end]]++;   
                // System.out.println("Here" + stringArray[end] + "," + count + "End:" + end);
                if(stringMap[stringArray[end]] <= needCharMap[stringArray[end]]){
                    count++;
                    
                }
            }
            
            if(count >= t.length()){
                
              // System.out.println("Originate Loop" + stringArray[end] + "," + stringMap[stringArray[begin]]);  
              while(stringMap[stringArray[begin]] > needCharMap[stringArray[begin]] || needCharMap[stringArray[begin]] == 0){
                  
                  // System.out.println(stringArray[begin] + "," +stringMap[stringArray[begin]]);
                  if(stringMap[stringArray[begin]] > needCharMap[stringArray[begin]])
                      stringMap[stringArray[begin]]--;
                  
                  begin++;
              }  
               
              // System.out.println("Begin " + begin + "End " + end);
              if(optLen > end - begin){
                   // System.out.println("Begin " + begin + "," + end);
                  subStringExists = true;
                  optLen = end - begin;
                  optBegin = begin;
                  optEnd = end;
              }
            }
        }
        
        // System.out.println(optBegin + ", " + optEnd);
        if(!subStringExists) return "";
        return s.substring(optBegin, optEnd + 1);
        
    }
}
