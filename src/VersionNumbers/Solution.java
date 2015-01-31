public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int i = 0;

        while(i < parts1.length && i < parts2.length) {
            int val1 = Integer.parseInt(parts1[i]);
            int val2 = Integer.parseInt(parts2[i]);

            if(val1 > val2)
                return 1;

            if(val1 < val2)
                return -1;

            i++;
        }

        if(i < parts1.length && Integer.parseInt(parts1[i]) > 0 &&
                i >= parts2.length)
            return 1;

        if(i >= parts1.length && i < parts2.length &&
                Integer.parseInt(parts2[i]) > 0)
            return -1;

        return 0;
    }
}
