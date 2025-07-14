// This question can be directly done by the knowledge of pge(previous greater element).
class StockSpanner {
    Stack<int[]> st;
    int initialIndex ;

    public StockSpanner() {
        st = new Stack<>();
        initialIndex=-1;
    }
    
    public int next(int price) {
        initialIndex++;
        while(!st.isEmpty()&&st.peek()[1] <= price){
            st.pop();
        }
        int ans = initialIndex-(st.isEmpty()?-1:st.peek()[0]) ;
        st.push(new int[]{initialIndex,price});
        return ans;
    }
}

