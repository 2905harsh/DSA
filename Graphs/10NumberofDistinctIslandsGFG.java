## Problem Link
[Count Distinct Islands](https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1)


class Solution {
    class pair{
        int row ;
        int col;
        public pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }

    int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> types = new HashSet<>();
        Queue<pair> q = new LinkedList<>();
        boolean [][] visited = new boolean[m][n];
        
        for(int i =0 ; i <m ; i++){
            for(int j =0 ; j<n ; j++){
                if(grid[i][j]==1 && visited[i][j]==false){
                    String code = "";
                    q.add(new pair(i,j));
                    visited[i][j]=true;
                    int basePairRow = i;
                    int basePairCol = j;
                    while(!q.isEmpty()){
                        pair curr = q.remove();
                        int currRow = curr.row;
                        int currCol = curr.col;
                        
                        // Added delimiters to avoid ambiguity
                        code += (currRow-basePairRow)+","+(currCol- basePairCol)+";"; 
                        int [] rc = {1,-1,0,0};
                        int [] cc = {0,0,1,-1};
                        for(int c = 0 ; c<4;c++){
                            if(isSafe(grid,visited,currRow+rc[c],currCol+cc[c],m,n)){
                                q.add(new pair(currRow+rc[c],currCol+cc[c]));
                                visited[currRow+rc[c]][currCol+cc[c]]=true;
                            }
                        }
                    }
                    types.add(code);
                    
                }
            }
        }
        return types.size();
        
        
    }
    
    public boolean isSafe(int[][] grid , boolean [][] visited , int row , int col , int m, int n){
        return (row>=0 && col>=0 && row<m && col<n && grid[row][col]==1 && visited[row][col]==false);
    }
}
