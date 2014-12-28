public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0)
            return 0;

        int i = 1;
        int j = 1;

        while(j < A.length) {
            A[i] = A[j];
            j++;

            if(A[i] != A[i - 1])
                i++;
        }

        return i;
    }
}
