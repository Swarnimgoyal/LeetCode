class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0; // Edge case: No trapping possible
        }

        Stack<Integer> stack = new Stack<>();
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            // Process stack while the current height is greater than the height at stack's top
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // The index of the "bottom" of the trapped water

                // If stack becomes empty after pop, break as no left boundary exists
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek(); // The left boundary
                int width = i - left - 1; // Distance between the left and right boundaries
                int waterHeight = Math.min(height[left], height[i]) - height[top];
                
                totalWater += width * waterHeight; // Add trapped water
            }

            stack.push(i); // Push the current index onto the stack
        }

        return totalWater;
    }
}
