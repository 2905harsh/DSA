// simple recursion (This will TLE at some test cases)
class Solution {
    public int rob(int[] nums) {
      //func(n) signifies maximum amount of money robbed between house 0 to house n without alerting the police.
      return func(nums.length-1,nums);
    }
    public int func(int houseNo,int[] nums){
      if(houseNo<0) return 0;
      int pick = nums[houseNo]+ func(houseNo-2,nums);
      int dntPick = 0 + func(houseNo-1,nums);
      return Math.max(pick,dntPick);
    }
}

// Recursion + Memoization
class Solution {

    public int rob(int[] nums) {
      int [] dp = new int [nums.length];
      Arrays.fill(dp,-1);
      //func(n) signifies maximum amount of money robbed between house 0 to house n without alerting the police.
      return func(nums.length-1,nums,dp);
    }

    public int func(int houseNo,int[] nums,int[]dp){
      if(houseNo<0) return 0;   // no houses left
      if(dp[houseNo]!=-1) return dp[houseNo];
      int pick = nums[houseNo]+ func(houseNo-2,nums,dp);
      int dntPick = 0 + func(houseNo-1,nums,dp);
      return dp[houseNo]=Math.max(pick,dntPick);
    }
}

/*
  * Complexity
	•	Time: O(n) → each house computed once due to memoization.
	•	Space: O(n) recursion stack + O(n) dp array.
*/


// Tabulation
class Solution {
    public int rob(int[] nums) { 
      if(nums.length==1) return nums[0];
      int [] dp = new int[nums.length];
      Arrays.fill(dp,-1);
      //func(n) signifies maximum amount of money robbed between house 0 to house n without alerting the police.
      dp[0] = nums[0];
      dp[1]= Math.max(nums[0],nums[1]);
      for(int i = 2 ; i<nums.length ;i++){
        int pick = nums[i] + dp[i-2];
        int dntpick = 0 + dp[i-1];
        dp[i] = Math.max(pick,dntpick);
      }
      return dp[nums.length-1];

        
    }
}

/* 
  * Complexity
	•	Time: O(n)
	•	Space: O(n) because of dp[].
*/

// Space Optimization
class Solution {
    public int rob(int[] nums) { 
      if(nums.length==1) return nums[0];
      //func(n) signifies maximum amount of money robbed between house 0 to house n without alerting the police.
      int prev2 = nums[0];
      int prev1= Math.max(nums[0],nums[1]);
      int curr ;
      for(int i = 2 ; i<nums.length ;i++){
        int pick = nums[i] + prev2;
        int dntpick = 0 + prev1;
        curr = Math.max(pick,dntpick);
        prev2 = prev1;
        prev1 = curr;
      }
      return prev1;

        
    }
}
/*
 * ⚡ Complexity
	•	Time: O(n)
	•	Space: O(1) (optimal)
 */

