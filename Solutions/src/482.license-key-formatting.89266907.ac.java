public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int count = 0;
        int ptr2 = S.length()-1;
        char[] resultData = new char[S.length()];
        List<Character> resultlist = new LinkedList<Character>();
        for(int i=S.length()-1; i >=0; i--){
           if(S.charAt(i) != '-'){
               resultlist.add(Character.toUpperCase(S.charAt(i)));
               ptr2--;
               count++;
           }
           if(count == K && i!= 0 && S.charAt(i) != '-'){
               count = 0;
               resultlist.add('-');
               ptr2--;
           }
        }
        ListIterator li = resultlist.listIterator(resultlist.size());
        StringBuilder resultString = new StringBuilder();
        count = 0;
        while(li.hasPrevious()){
            resultString.append(li.previous());
            if(count == 0 && resultString.toString().equals("-"))
            { 
                resultString.setLength(0); 
                
            }
            count++;
        }
        //String result = String.valueOf(resultData);
        //StringBuilder finalResult = new StringBuilder(result);
        //finalResult.insert(0,S.charAt(0));
        //return finalResult.toString();
        return resultString.toString();
    }
}
