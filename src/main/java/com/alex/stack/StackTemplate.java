package com.alex.stack;

import java.util.Stack;

public class StackTemplate {

    /**
     * Reverse Polish notation
     */
    public int evalRpn(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(stack.pop() - stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case  "/":
                    stack.push(stack.pop() / stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /**
     * Valid bracket
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case  '[':
                    stack.push(']');
                    break;
                case  '{':
                    stack.push('}');
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     *  Largest rectangle area
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int cur = 0;
            if (i < heights.length) {
                cur = heights[i];
            }

            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int index = stack.pop();
                int h =  heights[index];
                int w = i;
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    w = i - peek - 1;
                }
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }
        return max;
    }

    /**
     * Implement queue
     */
    static class MyQueue {
        private final Stack<Integer> stack1 = new Stack<>();
        private final Stack<Integer> stack2 = new Stack<>();

        // Initialize data structure
        public MyQueue() {}

        // Push element x to the back of the queue
        public void push(int x) {
            while (! stack2.isEmpty()) {
                int val = stack2.pop();
                stack1.push(val);
            }
            stack1.push(x);
        }

        // Remove the element from the front of the queue and return that element
        public int pop() {
            while (!stack1.isEmpty()) {
                int val = stack1.pop();
                stack2.push(val);
            }
            if (stack2.isEmpty()) return -1;
            return stack2.pop();
        }

        // Get the front element
        public int peek() {
            while (!stack1.isEmpty()) {
                int val = stack1.pop();
                stack2.push(val);
            }
            if (stack2.isEmpty()) return -1;
            return stack2.peek();
        }

        // Return whether the queue is empty
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
