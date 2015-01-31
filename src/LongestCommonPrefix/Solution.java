public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        int minLen = Integer.MAX_VALUE;
        String prefix;
        boolean isPrefix;

        for(String str : strs) {
            if(str.length() < minLen)
                minLen = str.length();
        }

        while(minLen > 0) {
            prefix = strs[0].substring(0, minLen);
            isPrefix = true;

            for(int i = 1; i < strs.length; i++) {
                if(!prefix.equals(strs[i].substring(0, minLen))) {
                    isPrefix = false;
                    break;
                }
            }

            if(isPrefix)
                return prefix;

            minLen--;
        }

        return "";
    }
}
