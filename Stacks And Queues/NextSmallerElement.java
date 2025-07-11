public int[] findNse(int [] arr){
        int [] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                nse[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            nse[st.pop()]= arr.length;
        }
        return nse;
}
