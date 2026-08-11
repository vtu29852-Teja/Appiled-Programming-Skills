import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            // Collision happens only when stack top is moving RIGHT (> 0) and current ast is moving LEFT (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // Top asteroid is smaller, it explodes; continue checking
                } else if (stack.peek() == -ast) {
                    stack.pop(); // Both are same size, both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true; // Current asteroid is smaller, it explodes
                    break;
                }
            }
            
            if (!exploded) {
                stack.push(ast);
            }
        }
        
        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}