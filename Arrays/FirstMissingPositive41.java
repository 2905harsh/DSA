class Solution {
    public int firstMissingPositive(int[] nums) {
        // Checking if 1 is present or not
        boolean flag = false;
       for(int i =0; i<nums.length;i++){
        if(nums[i]==1) flag = true;
        if(nums[i]<=0 || nums[i]>nums.length) nums[i] = 1;
       }

       if(flag == false) return 1;

       for(int i = 0 ; i<nums.length ; i++){
        int temp = Math.abs(nums[i]);
        int idx = temp -1;

        if(nums[idx]<0) continue;
        nums[idx]*=-1;
       }

       for(int i = 0 ; i<nums.length;i++){
        if(nums[i]>0) return i+1;
       }

       return nums.length+1;
}
}
