class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return NumberofSubarraysWithSumLessThanGoal(nums,goal) - NumberofSubarraysWithSumLessThanGoal(nums,goal-1);
    }
    public int NumberofSubarraysWithSumLessThanGoal(int[] nums,int goal){
        if(goal<0) return 0;
        int sum =0,count=0,l=0,r=0;
        while(r<nums.length){
            sum+= nums[r];
            while(sum>goal){
                sum=sum-nums[l];
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}
//time complexity : O(N)
//space complexity : O(1) as we are not using any extra space.