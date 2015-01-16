public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLen = 0;
        int currentLen = 0;
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                int index = map.get(c);

                if(index < start) {
                    currentLen++;
                } else {
                    if(currentLen > maxLen)
                        maxLen = currentLen;

                    start = index + 1;
                    currentLen = i - start + 1;
                }
            } else {
                currentLen++;
            }

            map.put(c, i);
        }

        return currentLen > maxLen ? currentLen : maxLen;
    }
}
