class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        // if nums is not rotated or rotated 'length' number of times.
        if (nums[l] < nums[r]) {
            return nums[l];
        }

        while (l < r) {
            int mid = (l) + (r - l) / 2;
            if (nums[r] < nums[mid]) { // if right have smaller element then go for it.
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return nums[l];

 }
}