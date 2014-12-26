import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char top;
        char c;

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty())
                    return false;

                top = stack.pop();

                if(top == '(' && c != ')')
                    return false;

                if(top == '{' && c != '}')
                    return false;

                if(top == '[' && c != ']')
                    return false;
            }
        }

        return stack.size() == 0;
    }
}
