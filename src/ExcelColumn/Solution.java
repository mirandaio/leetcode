public class Solution {
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        int letter;

        while(n > 0) {
            n--;
            letter = n % 26;
            title.append((char) (letter + 'A'));
            n = n / 26;
        }

        return title.reverse().toString();
    }
}
