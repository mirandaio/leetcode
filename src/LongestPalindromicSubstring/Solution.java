public class Solution {
    public String longestPalindrome(String s) {
        if(s == null)
            return null;

        if(s.length() <= 1)
            return s;

        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        String longest = s.substring(0, 1);
        int maxLen = 1;

        for(int i = 0; i < len; i++)
            isPalindrome[i][i] = true;

        for(int i = 0; i <= len - 2; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i+1] = true;
                longest = s.substring(i, i + 2);
            }
        }

        for(int d = 2; d < len; d++) {
            for(int i = 0; i < len - d; i++) {
                int j = d + i;

                if(s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    
                    if(j - i + 1 > maxLen && isPalindrome[i][j]) {
                        maxLen = j - i + 1;
                        longest = s.substring(i, j + 1);
                    }
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }

        return longest;
    }
}
