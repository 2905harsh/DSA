// Simple recursion
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return func(m-1,n-1,grid);
    }

    public int func(int row , int col , int[][] grid){
    if(row<0 || col <0) return 100000;
    if(row==0 && col==0) return grid[row][col];
    int left = grid[row][col] + func(row,col-1,grid);
    int up = grid[row][col] + func(row-1,col,grid);
    return Math.min(left,up);
    }
}

// Memoization
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return func(m-1,n-1,grid,dp);
    }

    public int func(int row , int col , int[][] grid,int[][]dp){
    if(row<0 || col <0) return 100000;
    if(row==0 && col==0) return dp[row][col]=grid[row][col];
    if(dp[row][col]!=-1) return dp[row][col];
    int left = grid[row][col] + func(row,col-1,grid,dp);
    int up = grid[row][col] + func(row-1,col,grid,dp);
    return dp[row][col]=Math.min(left,up);
    }
}

// Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) dp[0][0] = grid[0][0];
                else{
                int left = (col>0) ? (grid[row][col] + dp[row][col - 1]) : 100000;
                int up =   (row>0) ? grid[row][col] + dp[row - 1][col] : 100000;
                dp[row][col] = Math.min(left, up);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

// Space Optimization

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[n];
        for (int row = 0; row < m; row++) {
            int[] curr = new int [n]; 
            for (int col = 0; col < n; col++) {
                if(row==0 && col==0) curr[col]=grid[0][0];
                else{
                int left = (col>0) ? grid[row][col] + curr[col - 1] : 40000;
                int up =   (row>0)? grid[row][col] + temp[col] : 40000;
                curr[col] = Math.min(left, up);
                }
            }
            temp=curr;
        }
        return temp[n-1];
    }
}