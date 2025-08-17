// Recursion+Memoization
// User function Template for Java
class Solution {
    int minCost(int[] height) {

        int[] dp = new int[height.length];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return func(height.length-1,dp,height);
    }
    int func(int stairNo , int[]dp,int[] height){
        if(dp[stairNo]!=-1) return dp[stairNo];
        int leftRec = func(stairNo-1,dp,height) + Math.abs(height[stairNo]-height[stairNo-1]);
        int rightRec = Integer.MAX_VALUE;
        if(stairNo>1) {
            rightRec = func(stairNo-2,dp,height) + Math.abs(height[stairNo]-height[stairNo-2]);
        }
        return dp[stairNo]=Math.min(leftRec,rightRec);
    }
}

// Tabulation
class Solution {
    int minCost(int[] height) {
     
        // base case
        if(height.length==1) return 0;
        
        int [] dp = new int[height.length];
        dp[0]=0;
        dp[1]= dp[0]+ Math.abs(height[1]-height[0]);
        
        for(int i = 2 ; i<height.length ; i++){
            int ls = dp[i-1]+Math.abs(height[i]-height[i-1]);
            int rs = dp[i-2]+Math.abs(height[i]-height[i-2]);
            dp[i] = Math.min(ls,rs);
        }
        
        return dp[height.length-1];
    }
}

// space optimized
class Solution {
    int minCost(int[] height) {
        // base case
        if(height.length==1) return 0;
        int prev2=0;
        int prev1= prev2+ Math.abs(height[1]-height[0]);
        int curr;
        for(int i = 2 ; i<height.length ; i++){
            int ls = prev1+Math.abs(height[i]-height[i-1]);
            int rs = prev2+Math.abs(height[i]-height[i-2]);
            curr = Math.min(ls,rs);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}