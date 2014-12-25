public class Solution {
    public int atoi(String str) {
        if(str == null || str.length() == 0)
            return 0;

        boolean isNegative = false;
        double num = 0;
        int i = 0;

        while(i < str.length() && Character.isWhitespace(str.charAt(i)))
            i++;

        if(str.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if(str.charAt(i) == '+') {
            i++;
        }

        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            num = num * 10 + (str.charAt(i) - '0');
            i++;
        }

        if(isNegative)
            num = -num;

        if(num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if(num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) num;
    }
}
