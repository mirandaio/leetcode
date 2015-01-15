public class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder current = new StringBuilder();
        ArrayList<String> set = new ArrayList<String>();
        generateParenthesis(n, n, set, current);
        return set;
    }

    private void generateParenthesis(int left, int right,
        ArrayList<String> set, StringBuilder current) {
        if(left == 0 && right == 0) {
            set.add(current.toString());
            return;
        }

        if(left > 0) {
            current.append('(');
            generateParenthesis(left - 1, right, set, current);
            current.deleteCharAt(current.length() - 1);
        }

        if(left < right) {
            current.append(')');
            generateParenthesis(left, right - 1, set, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
