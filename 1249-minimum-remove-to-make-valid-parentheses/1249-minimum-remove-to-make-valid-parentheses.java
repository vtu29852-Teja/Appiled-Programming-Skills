class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        // Pass 1: Build a character array / string and track invalid indices
        boolean[] toRemove = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    toRemove[i] = true; // Unmatched closing parenthesis
                } else {
                    stack.pop(); // Found matching opening parenthesis
                }
            }
        }
        
        // Any remaining '(' indices in stack are unmatched
        while (!stack.isEmpty()) {
            toRemove[stack.pop()] = true;
        }
        
        // Pass 2: Reconstruct string without marked invalid characters
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove[i]) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}