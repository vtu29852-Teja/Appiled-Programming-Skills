import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        // Traverse through nums2 to precompute the next greater elements
        for (int num : nums2) {
            // While the stack has elements and the current number is greater 
            // than the element at the top of the stack
            while (!stack.isEmpty() && stack.peek() < num) {
                // The current number is the next greater element for the popped item
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack
            stack.push(num);
        }

        // Build the result array for nums1 using the precomputed map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // Look up the value in the map; default to -1 if no greater element exists
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
