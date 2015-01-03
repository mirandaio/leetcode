public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> set = new HashSet<Integer>();
        int num;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                num = board[i][j] - '0';
                if(set.contains(num))
                    return false;

                if(board[i][j] != '.')
                    set.add(num);
            }
            set.clear();
        }

        for(int j = 0; j < 9; j++) {
            for(int i = 0; i < 9; i++) {
                num = board[i][j] - '0';
                if(set.contains(num))
                    return false;

                if(board[i][j] != '.')
                    set.add(num);
            }
            set.clear();
        }

        for(int i = 0; i <= 6; i += 3) {
            for(int j = 0; j <= 6; j += 3) {
                if(!validBox(i, j, board))
                    return false;
            }
        }

        return true;
    }

    private boolean validBox(int i, int j, char[][] board) {
        HashSet<Integer> set = new HashSet<Integer>();
        int num;

        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                num = board[i + m][j + n] - '0';
                if(set.contains(num))
                    return false;

                if(board[i + m][j + n] != '.')
                    set.add(num);
            }
        }

        return true;
    }
}
