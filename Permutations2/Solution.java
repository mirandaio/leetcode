public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        LinkedList<List<Integer>> permutations =
            new LinkedList<List<Integer>>();

        if(num.length == 0) {
            permutations.add(new LinkedList<Integer>());
            return permutations;
        }

        if(num.length == 1) {
            LinkedList<Integer> permutation = new LinkedList<Integer>();
            permutation.add(num[0]);
            permutations.add(permutation);
            return permutations;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        List<List<Integer>> partials;
        int[] shorter;

        for(int i = 0; i < num.length; i++) {
            if(!set.contains(num[i])) {
                shorter = remove(num, i);
                partials = permuteUnique(shorter);

                for(List<Integer> partial : partials) {
                    partial.add(0, num[i]);
                    permutations.add(partial);
                }

                set.add(num[i]);
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
