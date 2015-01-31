public class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int index = -1;

        for(int i = 0; i <= hLen - nLen; i++) {
            index = i;
            for(int j = 0; j < nLen; j++) {
                if(needle.charAt(j) != haystack.charAt(i + j)) {
                    index = -1;
                    break;
                }
            }

            if(index != -1)
                break;
        }

        return index;
    }
}
