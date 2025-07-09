// This is same problem as nge1LC496 but in this we have a concept of circular array.
// If we use a nested loop for looking back for every back in array to make it circular then it will costs us a O(n2) time complexity.
// Rather we will virtually add the same array after the first array ends.
// For eg    1,2,3,4,3 this will become 1,2,3,4,3,1,2,3,4,3 .
// index's   0 1 2 3 4                  0 1 2 3 4 5 6 7 8 9 .
// We won't change original array we will just assume it.
// We will use (index % arr.length) to make the index always in range of array.Because we are dealing with hypothetical index's . 

class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int [] ans = new int [n];
        Stack<Integer> st = new Stack<>();
        for(int j= 2*n-1 ; j>=0;j--){
            while(!st.isEmpty() && st.peek()<=arr[j%n]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[j%n]=-1;
                st.push(arr[j%n]);
            }
            else{
                ans[j%n] = st.peek();
                st.push(arr[j%n]);
            }
        }
        return ans;
    }
}

// Time Complexity

// for loop - At max can be 2N elements
// and At max you can end up removing 2N element from stack .You remove those elements that you push.
// So Time Complexity will be O(4N).

// Space Complexity - for stack O(2N) and for ans array O(N).

