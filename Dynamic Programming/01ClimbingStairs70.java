// Recursive + Memoization
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        return count(n,dp);

     }
     public int count(int n,int[] dp){
      if(dp[n]!=-1) return dp[n];
      else dp[n]= count(n-1,dp)+count(n-2,dp);
      return dp[n];
     }
}

// Tabulation
class Solution {
    public int climbStairs(int n) {
        // We will come to bottom from the top. 
        int [] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int curr = 2 ; curr<=n ; curr++){
            dp[curr] = dp[curr-1]+dp[curr-2];
        }
        return dp[n];
    }
}