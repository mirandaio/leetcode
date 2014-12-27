public class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1;
        int sum;

        for(int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + c;
            digits[i] = sum % 10;
            c = sum / 10;
        }

        if(c == 0)
            return digits;
            
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        
        for(int i = 1; i < result.length; i++)
            result[i] = digits[i - 1];

        return result;
    }
}
