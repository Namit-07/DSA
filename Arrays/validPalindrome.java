// Problem Statement: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
// Logic: Use two pointers to compare characters from the beginning and end of the string, moving towards the center while skipping non-alphanumeric characters.

public class validPalindrome {
    public static boolean isPalindrome(String s){
        
        int left = 0;
        int right = s.length() - 1;

        while(left<right){
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(!Character.isLetterOrDigit(l)){
                left++;
            }
            else if(!Character.isLetterOrDigit(r)){
                right--;
        }
        else {
            if (Character.toLowerCase(l) != Character.toLowerCase(r)){
                return false;
            }
            left++;
            right--;
        }
    }
    return true;
}
public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
    System.out.println(isPalindrome("race a car")); // false
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the string once with two pointers.
// Space Complexity: O(1) - We use constant space for pointers and character comparisons.