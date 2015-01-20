public class Solution {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> solutions = new ArrayList<String[]>();
        int[] rows = new int[n];
        solveNQueens(solutions, rows, 0);
        return solutions;
    }

    private void solveNQueens(ArrayList<String[]> solutions, int[] rows,
        int row) {

        if(row >= rows.length) {
            solutions.add(buildSolution(rows));
            return;
        }

        for(int col = 0; col < rows.length; col++) {
            rows[row] = col;

            if(isValid(rows, row))
                solveNQueens(solutions, rows, row + 1);
        }
    }

    private String[] buildSolution(int[] rows) {
        String[] solution = new String[rows.length];

        for(int i = 0; i < rows.length; i++) {
            StringBuilder row = new StringBuilder();

            for(int j = 0; j < rows.length; j++) {
                if(j == rows[i])
                    row.append('Q');
                else
                    row.append('.');
            }

            solution[i] = row.toString();
        }

        return solution;
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
