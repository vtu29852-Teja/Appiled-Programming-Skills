import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Quick optimization: odd lengths can't be balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push the expected closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If stack is empty or top doesn't match the closing bracket
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // If stack is empty, all open brackets were properly matched
        return stack.isEmpty();
    }
}