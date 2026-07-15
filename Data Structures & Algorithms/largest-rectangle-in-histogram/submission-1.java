class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            if (stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            right[stack.pop()] = heights.length;
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }

        return max;

    }
}
