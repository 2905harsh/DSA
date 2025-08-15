class Solution {
   public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] rc = { 1, -1, 0, 0 };
                    int[] cc = { 0, 0, 1, -1 };
                    for (int c = 0; c < 4; c++) {
                        if (isSafe(grid, i + rc[c], j + cc[c], m, n)) {
                            perimeter += 1;
                        }
                    }
                }
            }
        }
        return perimeter;
    }

    public boolean isSafe(int[][] grid, int row, int col, int m, int n) {
        return (row<0 || row>=m || col<0 || col>=n || grid[row][col]==0);
    }
}
