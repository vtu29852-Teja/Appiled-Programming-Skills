class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are greater than the current price
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // Discount is the top element on stack, or 0 if empty
            int discount = stack.isEmpty() ? 0 : stack.peek();
            result[i] = prices[i] - discount;

            // Push current price to stack
            stack.push(prices[i]);
        }

        return result;
    }
}