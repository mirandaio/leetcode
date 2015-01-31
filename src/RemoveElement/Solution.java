public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0;
        int j = 0;

        while(j < A.length) {
            A[i] = A[j];
            j++;

            if(A[i] != elem)
                i++;
        }

        return i;
    }
}
