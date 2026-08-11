class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for popped array
        
        for (int val : pushed) {
            stack.push(val); // Push the current element onto the stack
            
            // Pop elements from the stack while they match popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        
        // If all elements were popped successfully, j will equal popped.length
        return j == popped.length;
    }
}