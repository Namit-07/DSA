// Problem Statement: Given a string s, find the longest palindromic substring in s.
// Logic: This problem can be solved using Dynamic Programming by maintaining a 2D boolean array where each cell dp[i][j] indicates whether the substring from index i to j is a palindrome. We fill this table based on the length of the substring and update the longest palindrome found.

public class longestPalindromicSubstring {
    public static String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j] will be true if the substring from index i to j is a palindrome

        int start = 0; // To keep track of the starting index of the longest palindrome found
        int maxLength = 1; // To keep track of the maximum length of palindrome found

        // single character substrings are palindromes
        for(int i=0; i<n; i++){
            dp[i][i] = true; // Every single character is a palindrome
        }
        // check substrings
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i==1 || dp[i+1][j-1]){
                        dp[i][j] = true; // Mark the substring from index i to j as a palindrome

                        if(j-i+1>maxLength){
                            start = i; // Update the starting index of the longest palindrome found
                            maxLength = j-i+1; // Update the maximum length of palindrome found
                        }
                    }
                }
            }
        }
        return s.substring(start, start+maxLength);
    }
    public static void main(String[] args) {
        String s = "babad";
        longestPalindromicSubstring solution = new longestPalindromicSubstring();
        String result = solution.longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n^2) - We have two nested loops where the outer loop runs n times and the inner loop also runs up to n times in the worst case.
// Space Complexity: O(n^2) - We use a 2D boolean array of size n*n to store whether the substring from index i to j is a palindrome.