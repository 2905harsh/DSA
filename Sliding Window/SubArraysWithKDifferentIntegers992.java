// We will not solve this problem directly. Rather we will calculate the number of subarrays with atmost n different integers.
// subarray with k different integers = subarrays with atmost k different integers - subarrays with atmost k-1 differnet integers.


class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return subArrayWithAtMostNDifferentIntegers(nums,k)-subArrayWithAtMostNDifferentIntegers(nums,k-1);
    }
    
    // Now calculating the subarray with atmost n different integers is very easy .
    public int subArrayWithAtMostNDifferentIntegers(int[] nums,int n){
        // Now we be using 2 pointers and maintaining a sliding window them.
        // We will use a hashmap which will be storing the integers and its frequency.
        // For every element just simply add it to hashmap with its frequency.
        // Then check if hashmap length is greater than n , means we are having n+1 distinct integers in hashmap . 
        // So we have to shrink the sliding window . We will remove each occurence of the integer that is present on left pointer.
        // We have to update the count each time.
        int l=0;
        int r=0;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size() > n){
                int rm = nums[l];
                map.put(rm,map.get(rm)-1);
                if(map.get(rm) == 0){
                    map.remove(rm);
                }
                l++;
            }
            count += (r-l)+1;
            r++;
        }
        return count;
    }
}

/*
 * Complexity
 * ----------
 * Time:  O(N)
 *   • Two passes (for k and k‑1) over the array.
 *   • Each element is added to and removed from the sliding window once.
 *   • HashMap operations are O(1) on average.
 *
 * Space: O(min(N, k))   // O(N) worst‑case
 *   • The window’s HashMap holds at most k distinct integers.
 *   • If all elements are unique and k ≥ N, this grows to N.
 */
