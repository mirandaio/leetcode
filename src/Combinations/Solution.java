public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> combinations =
            new LinkedList<List<Integer>>();
        LinkedList<Integer> currentCombination = new LinkedList<Integer>();
        combineHelper(1, n, k, combinations, currentCombination);
        return combinations;
    }

    private void combineHelper(int m, int n, int k,
        LinkedList<List<Integer>> combinations,
        LinkedList<Integer> currentCombination) {

        if(k == 0) {
            LinkedList<Integer> combination =
                new LinkedList<Integer>(currentCombination);
            combinations.add(combination);
            return;
        }

        if(m > n)
            return;

        combineHelper(m + 1, n, k, combinations, currentCombination);
        currentCombination.add(m);
        combineHelper(m + 1, n, k - 1, combinations, currentCombination);
        currentCombination.removeLast();
    }
}
