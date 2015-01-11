public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] indexes = new int[2];

        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                indexes[0] = map.get(target - numbers[i]) + 1;
                indexes[1] = i + 1;
                break;
            } else {
                map.put(numbers[i], i);
            }
        }

        return indexes;
    }
}
