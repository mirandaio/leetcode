public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> solutions = new ArrayList<String[]>();
        char[][] board = new char[n][n];

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++)
                board[row][col] = '.';
        }

        solveNQueens(solutions, board, 0);
        return solutions;
    }

    private void solveNQueens(ArrayList<String[]> solutions, char[][] board,
        int row) {

        if(row >= board.length) {
            String[] solution = new String[board.length];

            for(int i = 0; i < board.length; i++) {
                StringBuilder boardRow = new StringBuilder();

                for(int j = 0; j < board.length; j++)
                    boardRow.append(board[i][j]);

                solution[i] = boardRow.toString();
            }

            solutions.add(solution);
            return;
        }

        for(int col = 0; col < board.length; col++) {
            board[row][col] = 'Q';

            if(isValid(board, row, col)) {
                solveNQueens(solutions, board, row + 1);
            }

            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int i;
        int j;
        for(i = 0; i < row; i++) {
            if(board[i][col] == 'Q')
                return false;
        }

        i = row - 1;
        j = col - 1;

        while(i >= 0 && j >= 0) {
            if(board[i][j] == 'Q')
                return false;

            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;

        while(i >= 0 && j < board.length) {
            if(board[i][j] == 'Q')
                return false;

            i--;
            j++;
        }

        return true;
    }
}
