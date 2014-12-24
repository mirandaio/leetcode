import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = num.length;

        for(int n : num) {
            if(map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);

            if(map.get(n) > len / 2)
                return n;
        }

        return -1;
    }
}
