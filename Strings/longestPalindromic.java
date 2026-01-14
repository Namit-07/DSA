// Problem Statement: Given a string, find the longest palindromic substring.
// Logic: Expand around center approach to check for palindromes. Then track the longest one found.

package Strings;

public class longestPalindromic {
    public static String longestPalindrome(String s){

            if(s == null || s.length() < 1) 
                return "";

            int start = 0, end = 0;

            for(int i=0; i<s.length(); i++){
                int len1 = expandFromCenter(s, i, i); // Odd length palindromes
                int len2 = expandFromCenter(s, i, i + 1); // Even length palindromes
                int len = Math.max(len1, len2);

                if(len>end - start){
                    start = i -(len -1)/2;
                    end = i + len/2;
                }
            }
            return s.substring(start, end + 1);
    }
    private static int expandFromCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println(longestPalindrome("cbbd"));  // Output: "bb"
    }
}

// Complexity Analysis:
// Time Complexity: O(n^2) - In the worst case, we might have to expand around each character for the entire length of the string.
// Space Complexity: O(1) - We are using only a constant amount of extra space
