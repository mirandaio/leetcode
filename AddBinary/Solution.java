public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder number = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum;
        int c = 0;

        while(i >= 0 || j >= 0) {
            sum = c;

            if(i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            c = sum >> 1;
            number.append(sum & 1);
        }

        if(c == 1)
            number.append(c);

        return number.reverse().toString();
    }
}
