public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m + n - 1;
        int aIndex = m - 1;
        int bIndex = n - 1;

        while(i >= 0) {
            if(aIndex >= 0 && bIndex >= 0) {
                if(A[aIndex] > B[bIndex]) {
                    A[i] = A[aIndex];
                    aIndex--;
                } else {
                    A[i] = B[bIndex];
                    bIndex--;
                }
            } else if(aIndex >= 0) {
                A[i] = A[aIndex];
                aIndex--;
            } else {
                A[i] = B[bIndex];
                bIndex--;
            }

            i--;
        }
    }
}
