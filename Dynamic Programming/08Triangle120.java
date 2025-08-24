// Memomization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[]rows : dp){
            Arrays.fill(rows,-100000);
        }
        return func(0,0,triangle,n,dp);
        
    }
    public int func(int start , int end , List<List<Integer>> triangle , int n ,int[][]dp){
        if(start==n-1){
            return dp[start][end]=(triangle.get(start)).get(end);
        }
        if(dp[start][end]!=-100000) return dp[start][end];
        int down = (triangle.get(start)).get(end) + func(start+1,end,triangle,n,dp);
        int diagonal = (triangle.get(start)).get(end) + func(start+1,end+1,triangle,n,dp);
        return dp[start][end]=Math.min(down,diagonal);
    }
}

// Tabulation
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // filling the last row
        for(int i=0 ; i<n ;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }

        for(int row = n-2 ; row>=0 ; row--){
            for(int j =0; j<triangle.get(row).size();j++){
                 dp[row][j]=Math.min(triangle.get(row).get(j)+dp[row+1][j],triangle.get(row).get(j)+dp[row+1][j+1]);
            }
        }
        return dp[0][0];
    }
}

// Space Optimization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[]dp = new int[n];

        // filling the last row
        for(int i=0 ; i<n ;i++){
            dp[i]=triangle.get(n-1).get(i);
        }

        for(int row = n-2 ; row>=0 ; row--){
            int [] temp = new int[n];
            for(int j =0; j<triangle.get(row).size();j++){
                 temp[j]=Math.min(triangle.get(row).get(j)+dp[j],triangle.get(row).get(j)+dp[j+1]);
            }
            dp=temp;
        }
        return dp[0];
    }
}

// Approach 1: Recursive + Memoization
// TC: O(n^2), SC: O(n^2) + O(n) recursion stack

// Approach 2: Tabulation (Bottom-Up 2D DP)
// TC: O(n^2), SC: O(n^2)

// Approach 3: Space Optimization with Temp Array
// TC: O(n^2), SC: O(n)
