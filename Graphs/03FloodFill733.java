// Question Link ==> https://leetcode.com/problems/flood-fill/
class Solution {
    class pair {
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public boolean isSafe(int[][] image, boolean[][] visited, int m, int n, int currRow, int currCol, int color,int starting_color) {
        if (currRow >= 0 && currRow < m && currCol >= 0 && currCol < n && image[currRow][currCol] == starting_color && visited[currRow][currCol] == false) {
            return true;
        }
        return false;

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int starting_color = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc]=color;

        while (!q.isEmpty()) {
            pair curr = q.remove();
            int currRow = curr.row;
            int currCol = curr.col;

            // Exploring the 4 directions Now
            int[] rowChange = { 1, -1, 0, 0 };
            int[] colChange = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                if (isSafe(image, visited, m, n, currRow + rowChange[i], currCol + colChange[i], color,starting_color)) {
                    q.add(new pair(currRow + rowChange[i], currCol + colChange[i]));
                    visited[currRow + rowChange[i]][currCol + colChange[i]] = true;
                    image[currRow + rowChange[i]][currCol + colChange[i]] = color;
                }
            }

        }
        return image;
    }
}
