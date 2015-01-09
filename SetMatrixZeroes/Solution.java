public class Solution {
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[] rows = new boolean[numRows];
        boolean[] cols = new boolean[numCols];

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(rows[i] || cols[j])
                    matrix[i][j] = 0;
            }
        }
    }
}
