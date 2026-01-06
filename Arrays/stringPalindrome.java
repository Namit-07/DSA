// Problem Statement: Given a string, check if it is a palindrome (reads the same forwards and backwards).
// Logic: Use two pointers, one starting at the beginning and the other at the end of the string, and compare characters until the pointers meet in the middle.

import java.util.Scanner;

public class stringPalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to check for palindrome: ");
        String str = sc.nextLine();

        int left = 0;
        int right = str.length() - 1;
        boolean isPalindrome = true;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println("The given string is Palindrome: " + isPalindrome);
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse half of the string to check for palindrome.
// Space Complexity: O(1) - No extra space is used. 