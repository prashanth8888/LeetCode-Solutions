public class Solution {
    public int longestValidParentheses(String s) {
       
      Stack<Integer> stack = new Stack<Integer>();
      int max = 0;
      int leftIndex = -1;
      char[] charArray = s.toCharArray();
      
      for(int i=0; i <charArray.length; i++){
          if(charArray[i] == '(')
                stack.push(i);
          else{
              if(stack.isEmpty())   leftIndex = i;
              else{
                  stack.pop();
                  if(stack.isEmpty()) max = Math.max(max,i-leftIndex);
                  else max = Math.max(max, i-stack.peek());
              }
          }
      }
      
      return max;
      
    }
}
