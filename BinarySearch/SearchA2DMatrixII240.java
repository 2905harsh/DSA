class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Since the 2D array is partially sorted.
        // Individual Rows are sorted left to right and Columns are sorted top to bottom. 

        // So we recognise a pattern where the array is sorted.
        // ______
        //       |
        //       | 
        //       |

        // We will apply the binary search in this fashion .
        // We will compare the intersecting element of row and column with target.
        // On this basis we change our row and column.

        int rowStart = 0;
        int colStart = n - 1;

        while (rowStart < m && colStart >= 0) {
            if (matrix[rowStart][colStart] == target)
                return true;
            else if (matrix[rowStart][colStart] > target)
                colStart--;
            else if (matrix[rowStart][colStart] < target)
                rowStart++;
        }
        return false;
    }
}
