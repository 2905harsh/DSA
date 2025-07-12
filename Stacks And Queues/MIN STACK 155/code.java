// We will use only single stack to solve this problem because using 2 stacks it will be very easy but we need to
// optimise the space complexity . 
// Hence we will use only 1 stack and perform all operations in O(1) time complexity.
// We will not store members to the stack.Rather we will store difference of the members and the curr min variable.
// if difference is positive then element we are entering is greater than minimum element.
// if difference is negative then element we are entering is smaller than minimum element.
class MinStack {

    int min;
    Stack<Long> st;  

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        if (st.isEmpty()) {
            min = x;
            st.push(0l);     // difference min - x = 0
        } else {
            st.push((long)x - min);  // store difference
            if (x < min) min = x;
        }
    }

    public void pop() {
        long diff = st.pop();
        if (diff < 0)  min = (int)(min - diff);  // restore previous min
    }

    public int top() {
        long diff = st.peek();
        if (diff >= 0) return (int)(min + diff);
        else return min;
    }

    public int getMin() {
        return min;
    }

}
