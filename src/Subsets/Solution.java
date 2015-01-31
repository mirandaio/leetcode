public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        LinkedList<List<Integer>> subsets = new LinkedList<List<Integer>>();
        LinkedList<Integer> currentSubset = new LinkedList<Integer>();
        subsetsHelper(0, S, subsets, currentSubset);
        return subsets;
    }

    public void subsetsHelper(int i, int[] S,
        LinkedList<List<Integer>> subsets,
        LinkedList<Integer> currentSubset) {
        if(i >= S.length) {
            LinkedList<Integer> subset =
                new LinkedList<Integer>(currentSubset);
            subsets.add(subset);
            return;
        }

        currentSubset.add(S[i]);
        subsetsHelper(i + 1, S, subsets, currentSubset);
        currentSubset.removeLast();
        subsetsHelper(i + 1, S, subsets, currentSubset);
    }
}
