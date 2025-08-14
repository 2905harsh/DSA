class Solution {
    class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row =row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Lets insert all 1 present on the boundary of grid to queue.
        for(int r = 0 ; r<m ; r++){
            if(grid[r][0]==1){
                q.add(new pair(r,0));
                visited[r][0]=true;
            } 
            if(grid[r][n-1]==1){
                q.add(new pair(r,n-1));
                visited[r][n-1]=true;
            } 
        }

        for(int c =0 ; c<n ; c++){
            if(grid[0][c]==1) {
                q.add(new pair(0,c));
                visited[0][c]=true;
            }
            if(grid[m-1][c]==1) {
                q.add(new pair(m-1,c));
                visited[m-1][c]=true;
            }
        }

        while(!q.isEmpty()){
            pair curr = q.remove();
            int currRow = curr.row;
            int currCol = curr.col;
            grid[currRow][currCol]=2; // marking those 1 to 2 who are/ends up to boundary.

            int [] rc = {1,-1,0,0};
            int [] cc = {0,0,1,-1};
            for(int c = 0 ; c<4 ; c++){
                if(isSafe(grid,visited,currRow+rc[c],currCol+cc[c],m,n)){
                    q.add(new pair(currRow+rc[c],currCol+cc[c]));
                    visited[currRow+rc[c]][currCol+cc[c]]=true;
                }
            }
        }
        
        int ans=0;
        for(int i=0 ; i<m;i++){
            for(int j =0 ; j<n ; j++){
                if(grid[i][j]==1) ans++;
                else if(grid[i][j]==2) grid[i][j]=1 ; // undo changes
            }
        }
        return ans;
    }

    public boolean isSafe(int[][] grid ,boolean[][] visited , int row , int col , int m , int n){
        return(row>=0 && row<m && col>=0 && col<n && visited[row][col]==false && grid[row][col]==1);
    }
}
