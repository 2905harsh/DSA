/* Problem difference
	•	In House Robber I: Houses are in a straight line → you just avoid adjacent houses.
	•	In House Robber II: Houses are in a circle → the first and last houses are adjacent.
  So, you cannot rob both house 0 and house n-1.

Idea

Break it into two linear problems (use House Robber I logic):
	1.	Case 1: Rob houses from 0 → n-2 (exclude last house).
	2.	Case 2: Rob houses from 1 → n-1 (exclude first house).
  Final answer = max(case1, case2)
*/

// I have used the space optimized solution of House Robber I in both cases.

class Solution {
    public int rob(int[] nums) {
      if(nums.length==1) return nums[0];
      if(nums.length==2) return Math.max(nums[0],nums[1]);
      return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
        
    }
    public int rob(int[] nums,int start, int end) { 
      //func(n) signifies maximum amount of money robbed between house 0 to house n without alerting the police.
      int prev2 = nums[start];
      int prev1= Math.max(prev2,nums[start+1]);
      int curr ;
      for(int i = start+2 ; i<=end;i++){
        int pick = nums[i] + prev2;
        int dntpick = 0 + prev1;
        curr = Math.max(pick,dntpick);
        prev2 = prev1;
        prev1 = curr;
      }
      return prev1;
   }

}