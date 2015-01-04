public class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsHelper(n, memo);
    }

    private int climbStairsHelper(int n, int[] memo) {
        if(memo[n] != 0)
            return memo[n];

        if(n < 0)
            return 0;

        int f;
            
        if(n <= 1)
            f = 1;
        else
            f = climbStairsHelper(n-1, memo) + climbStairsHelper(n-2, memo);

        memo[n] = f;
        return f;
    }
}
