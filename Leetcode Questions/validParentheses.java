// Problem Statement: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid An input string is valid if: Open brackets must be closed by the same type of brackets. Open brackets must be closed in the correct order.Every close bracket has a corresponding open bracket of the same type. Example 1: Input: s = "()" Output: true 

import java.util.*;

class validParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();

                if((ch==')' && top!='(' || ch=='}' && top!='{' || ch==']' && top!='[' )){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        validParentheses solution = new validParentheses();
        String s = "()";
        boolean result = solution.isValid(s);
        System.out.println("Is the string of parentheses valid? " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the length of the string. We traverse the string once to check for valid parentheses.
// Space Complexity: O(n) in the worst case, when all characters are opening brackets and we push them onto the stack.