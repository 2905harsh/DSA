// You can either have insert efficient code or remove efficient code.
// This Solution is insertion efficient O(1) .
// This takes O(N) for removal .
class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
        
    }
    
    public void push(int x) {
        first.push(x);
        
    }
    
    public int pop() {

        // Move all the element of first stack to second.
        // Then pop the element from the second stack.
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop();

        // Then again put all the elements back into the first stack.
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
 
    public int peek() {

        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked = second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
        
    }
    
    public boolean empty() {
        return first.isEmpty();
        
    }
}

