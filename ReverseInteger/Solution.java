public class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        long reverse = 0;
        long mul = (int) Math.pow(10, (int) Math.log10(x));

        while(x > 0) {
            int d = x % 10;
            reverse += d * mul;
            x /= 10;
            mul /= 10;
        }

        if(reverse > Integer.MAX_VALUE)
            return 0;

        reverse = isNeg ? -reverse : reverse;
        return (int) reverse;
    }
}
