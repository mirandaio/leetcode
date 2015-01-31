public class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        long reverse = 0;

        while(x > 0) {
            int d = x % 10;
            reverse = reverse * 10 + d;
            x /= 10;
        }

        if(reverse > Integer.MAX_VALUE)
            return 0;

        reverse = isNeg ? -reverse : reverse;
        return (int) reverse;
    }
}
