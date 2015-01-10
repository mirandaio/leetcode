public class Solution {
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;

        for(int i = 0; i < numRows; i++) {
            if(matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        for(int j = 0; j < numCols; j++) {
            if(matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        for(int i = 1; i < numRows; i++) {
            for(int j = 1; j < numCols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < numRows; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < numCols; j++)
                    matrix[i][j] = 0;
            }
        }

        for(int j = 1; j < numCols; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < numRows; i++)
                    matrix[i][j] = 0;
            }
        }

        if(row0) {
            for(int j = 0; j < numCols; j++)
                matrix[0][j] = 0;
        }

        if(col0) {
            for(int i = 0; i < numRows; i++)
                matrix[i][0] = 0;
        }
    }
}
