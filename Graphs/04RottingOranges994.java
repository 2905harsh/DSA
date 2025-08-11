class Solution {
    class pair {
        int rowNo;
        int colNo;

        public pair(int rowNo, int colNo) {
            this.rowNo = rowNo;
            this.colNo = colNo;
        }
    }

    public boolean isSafe(int[][]grid , int m , int n ,int row , int col){
        if(row>=0 && row<m && col>=0 && col<n && grid[row][col]==1){
            return true;
        }
        return false;
    }

    public int orangesRotting(int[][] grid) {
     // Queue will take all the rotten Orange Info
     Queue<pair> q = new LinkedList<>();
     int m = grid.length;
     int n = grid[0].length;
     int NoOfFreshOranges = 0;
     int TotalMinutes = 0 ;
     // Lets see how many rotten / fresh oranges we have initially.
     for(int i = 0 ; i<m;i++){
        for(int j =0 ; j<n ;j++){
           if(grid[i][j]==1) NoOfFreshOranges++;
           else if(grid[i][j]==2){ // if rotten add it to Queue.
            q.add(new pair(i,j));
           }
        }
     }

     while(!q.isEmpty()){
          if(NoOfFreshOranges!=0) TotalMinutes++;
          int size = q.size();
          for(int count = 0 ; count<size  ; count++){
            pair curr = q.remove();
            int currRow = curr.rowNo;
            int currCol = curr.colNo;
            // Now explore in 4 direction
            int []rowChange = {1,-1,0,0};
            int []colChange ={0,0,1,-1};
            for(int y = 0 ; y<4 ;y++){
                if(isSafe(grid,m,n,currRow+rowChange[y],currCol+colChange[y])){
                    grid[currRow+rowChange[y]][currCol+colChange[y]]=2;
                    q.add(new pair(currRow+rowChange[y],currCol+colChange[y]));
                    NoOfFreshOranges--;
                }
            }
          }
    }
    return (NoOfFreshOranges==0) ? TotalMinutes : -1;
    }
}
