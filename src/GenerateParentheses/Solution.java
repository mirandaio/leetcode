public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> set = new ArrayList<String>();
        char[] current = new char[2 * n];
        generateParenthesis(n, n, set, current, 0);
        return set;
    }

    private void generateParenthesis(int left, int right,
        ArrayList<String> set, char[] current, int count) {
        if(left == 0 && right == 0) {
            set.add(new String(current));
            return;
        }

        if(left > 0) {
            current[count] = '(';
            generateParenthesis(left - 1, right, set, current, count + 1);
        }

        if(left < right) {
            current[count] = ')';
            generateParenthesis(left, right - 1, set, current, count + 1);
        }
    }
}
