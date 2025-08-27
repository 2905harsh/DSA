// Memoization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int result = (int) 1e+9;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1000);
        }

        for (int col = 0; col < n; col++) {
            int temp = func(m - 1, col, matrix, dp);
            result = Math.min(result, temp);
        }
        return result;

    }

    // func(i,j) signifies going from (i,j) to any cell in top with min cost.
    public int func(int row, int col, int[][] matrix, int[][] dp) {

        if (row < 0 || col < 0 || col >= matrix.length)
            return (int) 1e+9;

        if (dp[row][col] != -1000)
            return dp[row][col];

        if (row == 0)
            return matrix[row][col];

        int l = matrix[row][col] + func(row - 1, col - 1, matrix, dp);
        int up = matrix[row][col] + func(row - 1, col, matrix, dp);
        int r = matrix[row][col] + func(row - 1, col + 1, matrix, dp);

        return dp[row][col] = Math.min(l, Math.min(up, r));

    }

}

// Tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // tabulation
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]dp = new int[m][n];

        // filling the first row
        for(int col=0;col<n;col++){
            dp[0][col]=matrix[0][col];
        }
        
        // rest are
        for(int row = 1 ; row<m ; row++){
            for(int col =0;col<n;col++){
                int left = (row>0 && col>0)?matrix[row][col]+dp[row-1][col-1]:(int)1e+9;
                int up = (row>=0)?matrix[row][col]+dp[row-1][col]:(int)1e+9;
                int right = (col<n-1)?matrix[row][col]+dp[row-1][col+1]:(int)1e+9;

                dp[row][col] = Math.min(left,Math.min(up,right));
            }
        }
        
        int ans = (int)1e+9;
        for(int col= 0 ; col<n ; col++){
            ans =  Math.min(ans,dp[m-1][col]);
        }

        return ans;
    }
}

// Space Optimization

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int [] dp = new int[n];

        for(int i = 0 ; i<n ; i++){
            dp[i]=matrix[0][i];
        }
        
        for(int row = 1 ; row<m ; row++){
            int [] temp = new int[n];
            for(int col =0;col<n;col++){
               int l = (col>=1)?matrix[row][col] + dp[col-1]:(int)1e+9;
               int up = matrix[row][col] + dp[col];
               int r = (col<n-1)?matrix[row][col] + dp[col+1]:(int)1e+9;
               temp[col]=Math.min(l,Math.min(up,r));
            }
            dp=temp;
        }

        int ans = (int)1e+9;
        for(int val : dp){
            ans = Math.min(ans,val);
        }
        return ans;
     }
}

/*

=============================================
   Minimum Falling Path Sum - DP Approaches
=============================================

1. Memoization (Top-Down Recursion + DP)
   - Time Complexity :  O(m * n)
   - Space Complexity: O(m * n) for DP table 
            + O(m) for recursion stack
            = approx O(m * n)

2. Tabulation (Bottom-Up, 2D DP)
   - Time Complexity:  O(m * n)
   - Space Complexity: O(m * n)

3. Space Optimization (Bottom-Up, 1D DP - Space Optimized)
   - Time Complexity:  O(m * n)
   - Space Complexity: O(n)   ✅ Best Practical Version

*/
