public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> minStack = new Stack<Integer>();; 
    int minCount = Integer.MAX_VALUE;
    int index = -1;
    public MinStack() {
    }
    
    public void push(int x) {
       if(x <= minCount){
           minStack.push(minCount);
           minCount = x;
       }
       minStack.push(x); 
    }
    
    public void pop() {
       if(minStack.peek() == minCount){
           minStack.pop();
           minCount = minStack.pop();
       }    
       else minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minCount;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
