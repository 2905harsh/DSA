/*
 You start at index 0, and each element nums[i] tells how far you can jump from that index (maximum). You need to check if it’s possible to reach the last index using the allowed jumps.

Goal: Can you reach the last index from the first?
Example:
nums = [2, 3, 1, 1, 4]
Yes, you can reach the end:
Jump 1 step to 3, then jump 3 steps to the end.

nums = [3, 2, 1, 0, 4]
No, you’re stuck at 0.
*/
class Solution {
    public boolean canJump(int[] nums) {
        
        // We will maintain a variable that records till which maximum index we can go.
        int MaxIndextillYouCanGoByJumping = 0;

        // We will traverse through each element in array.
        for(int i =0;i<nums.length;i++){
            // If during traversing we reach a position that you cannot reach by jumping , then you cannot reach last index.
            if(i>MaxIndextillYouCanGoByJumping) return false;

            // If by jumping you crossed the entire array then definately you can reach the last index.
            if(MaxIndextillYouCanGoByJumping>=nums.length) return true;

            //If you are at 2nd index and value of array at that index is 4 that means maximum you can go upto 6th index.
            MaxIndextillYouCanGoByJumping = Math.max(MaxIndextillYouCanGoByJumping,i+nums[i]);
        }
        return true;
    }
}

