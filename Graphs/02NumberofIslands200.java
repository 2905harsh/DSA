/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
*/

class Solution {

    class pair {
        int rowNo;
        int colNo;

        public pair(int rowNo, int colNo) {
            this.rowNo = rowNo;
            this.colNo = colNo;
        }
    }

    public boolean isSafe(char[][]grid,boolean[][]visited , int m , int n ,int row , int col){
        if(row>=0 && row<m && col>=0 && col<n && grid[row][col]=='1' && visited[row][col]==false){
            return true;
        }
        return false;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<pair> q = new LinkedList<>();

        int NoOfIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    q.add(new pair(i, j));
                    NoOfIslands++;
                }
                while (!q.isEmpty()) {
                    pair curr = q.remove();
                    int currRow = curr.rowNo;
                    int currCol = curr.colNo;

                    // Exploring 4 directions where we can go.
                    int[] rowChange = { 1, -1, 0, 0 };
                    int[] colChange = { 0, 0, 1, -1 };
                    for (int h = 0; h < 4; h++) {
                        if (isSafe(grid, visited, m, n, currRow + rowChange[h], currCol + colChange[h])) {
                            q.add(new pair(currRow + rowChange[h], currCol + colChange[h]));
                            visited[currRow + rowChange[h]][currCol + colChange[h]] = true;
                        }
                    }

                }
            }
        }
        return NoOfIslands;
    }
}
