// Problem Statement: Given two strings, find the length of their longest common substring.
// Logic: This problem can be solved using Dynamic Programming by maintaining a 2D array where each cell dp[i][j] represents the length of the longest common substring ending at str1[i-1] and str2[j-1]. If characters match, we extend the length by 1; otherwise, we reset it to 0.

public class longestCommonSubstring{
    public static int longCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1]; // dp[i][j] will store the length of longest common substring ending at str1[i-1] and str2[j-1]
        int maxLength = 0; // To keep track of the maximum length of common substring found

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; // Characters match, extend the common substring by 1
                    maxLength = Math.max(maxLength, dp[i][j]); // Update maxLength if we found a longer common substring
                } else {
                    dp[i][j] = 0; // Characters don't match, reset the length of common substring to 0
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String str1 = "ABABC";
        String str2 = "BABCA";
        int result = longCommonSubstring(str1, str2);
        System.out.println("Length of Longest Common Substring: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*m) - where n and m are the lengths of the two strings. We fill up a 2D array of size (n+1)*(m+1).
// Space Complexity: O(n*m) - We use a 2D dp array of size (n+1)*(m+1) to store lengths of longest common substrings for substrings.