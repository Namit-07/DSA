// Problem Statement: Implement a Queue (FIFO) using Stacks (LIFO).
// Logic: Use two stacks input and output to simulate queue operations. When output is empty, pour everything from input to output.(this reverses the order -> make it FIFO)

import java.util.Stack;

public class implementQueueUsingStacks {
    
    Stack<Integer> input;
    Stack<Integer> output;

    public void push(int x){
        input.push(x);
    }
    public int pop(){
        peek(); // Ensure output stack has the current elements
        return output.pop();
    }
    public int peek(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    public boolean empty(){
        return input.isEmpty() && output.isEmpty();
    }
    public static void main(String[] args) {
        implementQueueUsingStacks queue = new implementQueueUsingStacks();
        queue.input = new Stack<>();
        queue.output = new Stack<>();

        queue.push(1);
        queue.push(2);
        System.out.println("Front element: " + queue.peek()); // Returns 1
        System.out.println("Removed element: " + queue.pop()); // Returns 1
        System.out.println("Is queue empty? " + queue.empty()); // Returns false    
        System.out.println("Front element: " + queue.peek()); // Returns 2

    }
}

// Complexity Analysis:
// Time Complexity: Amortized O(1) for push, pop, and peek operations.
// Space Complexity: O(n), where n is the number of elements in the queue.
