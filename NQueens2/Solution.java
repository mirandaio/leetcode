public class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        int[] rows = new int[n];
        totalNQueens(count, rows, 0);
        return count[0];
    }

    private void totalNQueens(int[] count, int[] rows, int row) {
        if(row >= rows.length) {
            count[0]++;
            return;
        }

        for(int col = 0; col < rows.length; col++) {
            rows[row] = col;

            if(isValid(rows, row))
                totalNQueens(count, rows, row + 1);
        }
    }

    private boolean isValid(int[] rows, int row) {
        for(int i = 0; i < row; i++) {
            if(rows[row] == rows[i])
                return false;

            if(row - i == Math.abs(rows[row] - rows[i]))
                return false;
        }

        return true;
    }
}
