// We will mark all Os with # that will not be changed in our answer because they have a edge present on boundary.
class Solution {
    class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean isSafe(boolean [][] visited ,char[][] board , int row ,int col , int m ,int n){
        if(row >=0 && col>=0 && row<m && col<n && visited[row][col]==false && board[row][col]=='O') return true;
        return false;
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<pair> q = new LinkedList<>();

        // Lets add all the Os present at the boundary to the queue.
        for(int c = 0 ; c<n ; c++){
            if(board[0][c]=='O') q.add(new pair(0,c));
            if(board[m-1][c]=='O') q.add(new pair(m-1,c));
        }

        for(int r = 0 ; r<m ; r++){
            if(board[r][0]=='O') q.add(new pair(r,0));
            if(board[r][n-1]=='O') q.add(new pair(r,n-1));
        }

        boolean [][] visited = new boolean [m][n];

        while(!q.isEmpty()){
            pair curr = q.remove();
            int currRow= curr.row;
            int currCol = curr.col;
            visited[currRow][currCol]=true;
            board[currRow][currCol]='#';
            int []rc = {0,0,1,-1};
            int []cc = {1,-1,0,0};
            for(int k = 0 ; k<4 ; k++){
                if(isSafe(visited,board,currRow+rc[k],currCol+cc[k],m,n)){
                    q.add(new pair(currRow+rc[k],currCol+cc[k]));
                }
            }
        }

        for(int row =0 ; row<m ; row++){
            for(int col = 0 ; col<n ; col++){
                if(board[row][col]=='#') board[row][col]='O';
                else if(board[row][col]=='O') board[row][col]='X';
            }
        }
    }
}

