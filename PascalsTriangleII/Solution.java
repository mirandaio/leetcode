import java.util.List;
import java.util.LinkedList;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<Integer>();
        int[] row = new int[rowIndex + 1];

        for(int r = 0; r <= rowIndex; r++) {
            int len = r + 1;
            int prev = 1;
            int temp;

            for(int c = 0; c < len; c++) {
                if(c == 0) {
                    row[c] = 1;
                } else {
                    temp = row[c];
                    row[c] = prev + row[c];
                    prev = temp;
                }
            }
        }

        for(int n : row)
            list.add(n);

        return list;
    }
}
