//This Solution will be the removal efficient O(1) but takes O(N) in insertion
class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
      // We will enter the new element at the bottom of first stack.
      // For that we temporarily need to empty the first stack and move all element to second stack.
      // After inserting the new element we will again move all elements back to first stack.
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(x);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }
    
    public int pop() {
        return first.pop();
        
    }
    
    public int peek() {
        return first.peek();
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

