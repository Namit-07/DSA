// Problem Statement: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// Logic: Use a stack to keep track of opening brackets and ensure they are properly closed in the correct order.

import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if((ch==')' && top!='(') || (ch=='}' && top!='{') || (ch==']' && top!='[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([{}])";
        String s4 = "((()))";
        String s5 = "({[)]}";

        System.out.println(s1 + " is valid: " + isValid(s1)); // true
        System.out.println(s2 + " is valid: " + isValid(s2)); // false
        System.out.println(s3 + " is valid: " + isValid(s3)); // true
        System.out.println(s4 + " is valid: " + isValid(s4)); // true
        System.out.println(s5 + " is valid: " + isValid(s5)); // false
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the length of the string. We traverse the string once.
// Space Complexity: O(n) in the worst case, when all characters are opening brackets and are pushed onto the stack.