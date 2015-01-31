public class Solution {
    public List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> permutations =
            new LinkedList<List<Integer>>();
        if(num.length == 0) {
            permutations.add(new LinkedList<Integer>());
            return permutations;
        }

        if(num.length == 1) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(num[0]);
            permutations.add(list);
            return permutations;
        }

        List<List<Integer>> partials;
        int[] shorter;

        for(int i = 0; i < num.length; i++) {
            shorter = remove(num, i);
            partials = permute(shorter);

            for(List<Integer> permutation : partials) {
                permutation.add(0, num[i]);
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    private int[] remove(int[] arr, int i) {
        int[] result = new int[arr.length - 1];

        for(int j = 0; j < i; j++)
            result[j] = arr[j];

        for(int j = i; j < result.length; j++)
            result[j] = arr[j + 1];

        return result;
    }
}
