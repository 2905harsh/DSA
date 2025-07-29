class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // ➡ Left to Right
            for (int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;

            // ⬇ Top to Bottom
            for (int j = rowStart; j <= rowEnd; j++) {
                ans.add(matrix[j][colEnd]);
            }
            colEnd--;

            // Since above we have changed the rowStart and ColEnd values we need now an additional checks to make sure that we do not visit the same cell again.
            // Its prevents 
            //1Duplicate visits to the same row/column
            //2 Out-of-bound errors

            // ⬅ Right to Left
            if (rowStart <= rowEnd) { // Additional check
                for (int k = colEnd; k >= colStart; k--) {
                    ans.add(matrix[rowEnd][k]);
                }
                rowEnd--;
            }

            // ⬆ Bottom to Top
            if (colStart <= colEnd) {.  // Additional check
                for (int l = rowEnd; l >= rowStart; l--) {
                    ans.add(matrix[l][colStart]);
                }
                colStart++;
            }
        }
        return ans;
    }
}