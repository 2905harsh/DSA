// In order to find the maximum numbers of consective 1's when we can flip at most k 0's.
// So to do so we find a subarray having k zeros with the largest length.
// In example {1,1,1,0,0,0,1,1,1,1,0}
// if we select the part {0,1,1,1,1,0} having length 6 and have 2 zeros.We can flip them to make 6 consective 1's.{1,1,1,1,1,1}.
// So we will use 2 pointers l and r and a sliding window between l and r .
// Both will start from 0th index and we will maintain the records of how many zeros we have in our subarray/window.
// If the element at right(r) is not zero we will only move r or you can say expand the window size.

// Major work will be there when the element at (r)right currently is 0.
// Case 1. So here we will check if numbers of zeros currently we have in our subarray is less than k , so we will simply increase the number of zeros we have in our subarray and move r to right or expand window. 
// Case 2.  If the numbers of zeros we have in our subarray is already equal to k then we cannot have zeros more than that . So now we will move the (l)left in such a way that it removes 1 zero from the window.

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int currentNumberOfZeros = 0;
       while(r<nums.length){
            if(nums[r]==0){
                if(currentNumberOfZeros==k){
                    while(nums[l]!=0){
                        l++;
                    }
                    l=l+1;
                }
                else currentNumberOfZeros++;
                maxLength = Math.max(maxLength,r-l+1);
                r++;
            }
            else if(nums[r]!=0){
               maxLength = Math.max(maxLength,r-l+1);
               r++;
            }
        }
        return maxLength;
    }
}
