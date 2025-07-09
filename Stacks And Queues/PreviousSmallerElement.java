class Solution {
    public int[] leftSmaller(int[] arr) {
        int [] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;

    }
}
 // https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1

//  Given an array arr[] of integers, for each element in the array, find the nearest smaller element on its left. If there is no such smaller element, return -1 for that position
