// Problem Statement: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// Logic: Use two stacks, one for normal stack operations and another to keep track of the minimum elements.

import java.util.Stack;

public class minStack {
    
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public minStack(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int val){
        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    public void pop(){
        int removed = stack.pop();

        if(removed == minStack.peek()){
            minStack.pop();
        }
    }
    public int top(){
        return stack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        System.out.println("Current Min: " + minStack.getMin()); // Returns -3
        minStack.pop();

        System.out.println("Top Element: " + minStack.top());    // Returns 0
        System.out.println("Current Min: " + minStack.getMin()); // Returns -2
    }
}

// Complexity Analysis:
// Time Complexity: O(1) for all operations (push, pop, top, getMin).
// Space Complexity: O(n) in the worst case, where n is the number of elements in the stack.
