class Solution {
    public void reverseArray(int[] temp){
        int i = 0; 
        int j = temp.length-1;
        while(i<j){
            int bk = temp[i];
            temp[i] = temp[j];
            temp[j] = bk;
            i++;
            j--;
        }
  }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose of matrix
        for(int i =0 ; i<n ; i++){
            for(int j =i+1 ; j<n;j++){
                    int temp = matrix[j][i];
                    matrix[j][i]= matrix[i][j];
                    matrix[i][j] = temp;
            }
        }

        // reversing the each row to get the rotated image
        for(int[] temp : matrix){
            reverseArray(temp);
        }
    }
}
