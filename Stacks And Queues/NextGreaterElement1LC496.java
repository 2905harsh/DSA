// This is a intuition for calculating the next greater element (nge) in an array. Start moving from the end to start.
// Treat all the numbers in array as a building of that height and on each building a person is sitting who can see only above , he cannot see below.
// If a person could not see any building then nge for that element will be -1.
// If some small buildings are between tall buildings remove them they cannot be anyone's nge because person can see only above not below.
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i = nums2.length-1 ; i>=0 ; i--){
                while(!st.isEmpty()&& st.peek()<nums2[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    map.put(nums2[i],-1);
                    st.push(nums2[i]);
                }
                else{
                    map.put(nums2[i],st.peek());
                    st.push(nums2[i]);
                }
        }

        int []ans = new int[nums1.length];
        for(int i = 0 ;i<nums1.length ; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans; 
    }
}

// This is leetcode problem 496. Next Greater Element I . 

// input question [1,3,4,2]

//     |
//   | |
//   | | |
// | | | |
// 1 3 4 2

// Starting from 2 we cannot see any building so nge is -1.
// At 4 we cannot see any building larger so nge is -1.
// At 3 we can see top of 4 so nge is 4.
// At 1 we can see top of 3 so nge is 3.
// So the answer is [3,4,-1,-1].
