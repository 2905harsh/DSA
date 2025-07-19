class Solution {
    public int pivotIndex(int[] nums) {
        // Calculating the total sum
        int TotalSum = 0;
        for(int ele : nums){
            TotalSum+=ele;
        }
        // Calculating the pivot index
        int LeftSum = 0; // for the first element left sum is 0.
        int RightSum;
        for(int i = 0 ; i<nums.length;i++){
              RightSum = TotalSum-LeftSum-nums[i];
              if(LeftSum == RightSum) return i;
              else LeftSum+=nums[i];
        }
        return -1;
    }
}
// This is Done without using any Extra Space.
// Used the concept of prefixsum Stored in Variable LeftSum here.
