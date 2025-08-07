//converting the problem from “remove elements from start or end to reduce x to zero” to find the longest subarray summing to TotalSum - x” → smart and efficient (linear time).
class Solution {
    public int minOperations(int[] nums, int x) {
        // Base Case 
        if (nums.length == 1) {
            if (nums[0] == x)
                return 1;
            else
                return -1;
        }

        int TotalSum = 0;
        for (int c : nums) {
            TotalSum += c;
        }

        int ans = Integer.MAX_VALUE;
        
        int l = 0;
        int our_New_target = TotalSum - x;

        if (our_New_target < 0) return -1;

        int window_sum = nums[l];

        if (window_sum == our_New_target) ans = Math.min(ans, nums.length - 1);

        for (int r = 1; r < nums.length; r++) {
            window_sum += nums[r];
            while (window_sum > our_New_target) {
                window_sum -= nums[l];
                l++;
            }
            if (window_sum == our_New_target) {
                // a potential answer is found.
                ans = Math.min(ans, nums.length - (r - l + 1));
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
