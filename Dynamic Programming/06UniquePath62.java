// Normal Recursion
// func(i,j)=> No of unique ways to reach to (i,j) from (0,0).
class Solution {
    public int uniquePaths(int m, int n) {
        return func(m-1,n-1);
        
    }
    public int func(int row,int col){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        int left = func(row,col-1);
        int right = func(row-1,col);
        return (left+right);
    }
}

// Memoization
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int [][]dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        func(m-1,n-1,dp);
        return dp[m-1][n-1];
        
    }
    public int func(int row,int col,int[][]dp){

        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }

        if(dp[row][col]!=-1) return dp[row][col];
        int left = func(row,col-1,dp);
        int up = func(row-1,col,dp);
        return dp[row][col]=(left+up);
    }
}


// Tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;
        int [][]dp = new int[m][n];
        for(int i = 0 ; i<m ;i++){
            for(int j=0 ; j<n ; j++){
                if(i==0 && j==0) dp[i][j]=1;
                else  dp[i][j]= ((i>0)?dp[i-1][j]:0) + ((j>0)?dp[i][j-1]:0);
            }
        }
        return dp[m-1][n-1];
   }
}

// Space Optimized
class Solution {
    public int uniquePaths(int m, int n) {
        int []dp = new int[n];
        for(int i = 0 ; i<m ;i++){
            int [] temp = new int[n];
            for(int j=0 ; j<n ; j++){
                if(i==0 && j==0) temp[j]=1;
                else temp[j]= ((i > 0) ? dp[j] : 0) + ((j > 0) ? temp[j-1] : 0);
            }
            dp=temp;
        }
        return dp[n-1];
   }
}