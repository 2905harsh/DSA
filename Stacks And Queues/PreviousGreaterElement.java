import java.util.Stack;

public class PreviousGreaterElement {
  public static void main(String[] args) {
    int [] arr = {100,80,60,70,60,75,85};
    int [] ans = new int[arr.length];
    Stack <Integer> st = new Stack<>();
    for(int i=0;i<arr.length;i++){
      if(st.isEmpty()){
        ans[i] = -1;
        st.push(i);
      }
      else{
        while(arr[st.peek()]<arr[i]){
          st.pop();
        }
        ans[i] = st.peek();
        st.push(i);
      }

    }

    // Printing final answer array
    for(int p = 0;p<ans.length;p++){
      System.out.print(ans[p]+" ");
    }
}
}

// OUTPUT :
// -1 0 1 1 3 1 0
// Explanation: The output array contains the indices of the previous greater elements for each element in the input array.