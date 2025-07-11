class Solution {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder("");
        Stack<String> st = new Stack<>();       //We will enter only valid parts to stack they will form our answer.
        String[] arr = path.split("[/]");
        for(String s : arr){
            if(s.equals("") || s.equals(".")){  // Skipping the current or empty directory.
                continue;
            }
            else if(s.equals("..")){        // If .. is encountered we will go back to previous directory
               if(!st.isEmpty()) st.pop();
            }
            else{                        
                st.push(s);
            }
        }

        while(!st.isEmpty()){
            ans.insert(0,st.pop());
            ans.insert(0,"/");
          
        }
        if (ans.length()==0) return "/";
        else return ans.toString();
    }
}

// We will not use any string variable ans to make our final answer like ans = ans+"/"+st.pop().Beacuse 
/*  Each String concatenation takes O(m) time, where m is the current length of ans.
So repeated string concatenation like this causes total time:
O(1 + 2 + 3 + .......... + k) = O(k^2)
👉 This is because Java strings are immutable, and repeated concatenation creates new strings each time.

⚠️ Optimization Tip:

Use StringBuilder instead of ans = "/" + ... to reduce from O(k^2) to O(k).
*/

// Time Complexity: O(N) for traversing the path and O(N) for popping the elements from the stack.