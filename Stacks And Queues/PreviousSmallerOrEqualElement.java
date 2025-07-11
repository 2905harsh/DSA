public int[] findPseE(int[] arr){
        int[]pseE =  new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            pseE[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        return pseE;
}
