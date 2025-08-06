class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0 ; 
        int r = 0;
        int ans = Integer.MAX_VALUE;
        int temp = 0 ;
        while(r<nums.length){
            temp+=nums[r];
            while(temp>=target){ // potential answer is founded.
                if(r-l+1<ans){
                    ans=r-l+1;
                }             
                temp -= nums[l];  // now we will try to shrink the sliding window from the left side.
                l++; 
            }
        r++;
        }
        return (ans==Integer.MAX_VALUE)?0:ans;
    }
}
