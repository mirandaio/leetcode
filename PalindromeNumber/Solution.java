public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int div = (int) Math.pow(10, (int) Math.log10(x));
        int left;
        int right;

        while(x > 0) {
            left = x / div;
            right = x % 10;

            if(left != right)
                return false;

            x = x % div;
            x = x / 10;
            div /= 100;
        }

        return true;
    }
}
