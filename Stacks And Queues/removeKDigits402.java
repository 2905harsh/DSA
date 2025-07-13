class Solution {
    public String removeKdigits(String num, int k) {
        // base cases 

        // 1. What if k equals to length of the num .
        if(k == num.length()) return "0"; // we will eventually end up removing everything from stack .

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
                // We have to remove k digits from the given string based number.
                // If the top element of stack is greater than the element we are entering so remove that element.
                while(!st.isEmpty() && st.peek() > num.charAt(i)-'0'  && k>0){
                st.pop();
                k--;
                }
                st.push(num.charAt(i)-'0');
        }

         // 2. If string is given in such a way such that it increases only . 
        // like '123456' we end up pushing everything to stack without removing anything. 
        // So in the end we will pop top k elements from the stack.


        if(k>0){
            while(k>0){
                st.pop();
                k--;
            }
        }

        // Entering the numbers to String Builder that will form the final answer from the stack.
        StringBuilder ans = new StringBuilder("");
        while(!st.isEmpty()){
            ans.insert(0,Integer.toString(st.pop()));
        }

        // Removing any trailing zeros if any for eg 0002324 will become 2324.
        while(ans.length() > 0 && ans.charAt(0) == '0'){
                 ans.deleteCharAt(0);
        }

        //  If the string was 00000 everything will be removed so we will return "0" otherwise we will return ans 
        return (ans.length()==0) ? "0": ans.toString(); // StringBuilder converted to String using .toString Method.
}
}

