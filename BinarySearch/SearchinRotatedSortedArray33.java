class Solution {
    public int search(int[] nums, int target) {
        return ModifiedSearch(nums, target, 0, nums.length - 1);
    }

    public int ModifiedSearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left) + (right - left) / 2;
        if (nums[mid] == target) return mid;

        // now we check which part is sorted
       
        if (nums[left] <= nums[mid]) {   // Yes left part is sorted.
            if (nums[left] <= target && nums[mid] > target) {
                // answer can be in left then.
                return ModifiedSearch(nums, target, left, mid - 1);
            } else {
                // answer can be in right then.
                return ModifiedSearch(nums, target, mid + 1, right);
            }
        } 
        else {  // yes right part is sorted.
            if(nums[mid]<target && target<=nums[right]){
                // answer can be in right then.
                 return ModifiedSearch(nums, target, mid+1, right);
            }
            else{
                // answer can be in left then.
                return ModifiedSearch(nums, target, left, mid - 1);
            }
        }
}
}
