// This Can be done via Knowledge of next smaller element (nse) and previous smaller element(pse).
// By simple mathematics a formula for a area by particular bar in histogram can be derived as area = heightx(nse-pse-1).
// If you are not getting the nse of any element then take it as length of array.
// If you are not getting the pse of any element then take it as -1.
// We will use a concept of monotonic stack (increasing).
// We can pre-calculate the pse and nse for each element then calculate the individual areas.
// But that will not be a optimised way.Rather we will calculate them on the go.

class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int area=0;
        Stack<Integer>st = new Stack<>(); // In the stack we will be storing the index's not the height of bars.
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                int idx = st.pop();
                int nse = i;
                int pse = (!st.isEmpty()) ? st.peek() : -1;
                area = Math.max(area,arr[idx]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            int pse = (st.isEmpty()) ? -1 : st.peek();
            int nse = n;
            area = Math.max(area,arr[idx]*(nse-pse-1));
        }
        return area;
    }
}
// Time Complexity: O(N) for traversing the array and O(N) for popping the elements from the stack. 
// Space Complexity: O(N) for the stack.





