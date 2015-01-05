public class Solution {
    public int climbStairs(int n) {
        if(n <= 1)
            return 1;

        int c0 = 1;
        int c1 = 1;
        int c = 0;

        for(int i = 2; i <= n; i++) {
            c = c0 + c1;
            c0 = c1;
            c1 = c;
        }

        return c;
    }
}
