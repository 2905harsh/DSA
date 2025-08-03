class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // We will assume the 2D matrix in the form of virtual 1D sorted array in our mind because the 2D array is already sorted in question.
        // So for [[1,3,5,7],[10,11,16,20],[23,30,34,60]] the 1D array looks like [1,3,5,7,10,11,16,20,23,30,34,60].
        // The 2D matrix have mxn element here 12 elements . So the indices in 1D array will begin from 0 to mxn-1 here 11.
        // We will apply binary search on 1D array easily.
        // The main takeaway here is to find the row_number and col_number from the 1D array index.
        // We will use simple formula for calculating the row_number = index/n and col_number = index%n.
        int low = 0;
        int high = m*n-1;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            // The main task is to find row and col from the mid;
            int row= mid/n;
            int col= mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]<target){
                low = mid+1;
            }
            else if(matrix[row][col]>target){
                high = mid-1;
            }
        }
        return false;
    }
}
