public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        char[] arr = new char[len];
        int i = len - 1;
        int j = 0;
        int newLen;

        while(i >= 0) {
            if(!Character.isWhitespace(s.charAt(i)) ||
                (i + 1 < len && !Character.isWhitespace(s.charAt(i + 1)))) {
                arr[j] = s.charAt(i);
                j++;
            }
            i--;
        }

        i = 0;
        newLen = j;

        while(i < newLen) {
            while(i < newLen && Character.isWhitespace(arr[i]))
                i++;

            j = i + 1;

            while(j < newLen && !Character.isWhitespace(arr[j]))
                j++;

            reverseWord(arr, i, j);
            i = j;
        }

        return (new String(arr, 0, newLen)).trim();
    }

    private void reverseWord(char[] arr, int i, int j) {
        char c;
        j--;

        while(i < j) {
            c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }
}
