import java.util.List;
import java.util.LinkedList;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<List<Integer>>();
        int[][] matrix = new int[numRows][numRows];

        for(int row = 0; row < numRows; row++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            int i = row;
            int j = 0;

            while(i >= 0) {
                if(i - 1 < 0 || j - 1 < 0)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = matrix[i][j-1] + matrix[i - 1][j];

                list.add(matrix[i][j]);
                i--;
                j++;
            }

            triangle.add(list);
        }
        
        return triangle;
    }
}
