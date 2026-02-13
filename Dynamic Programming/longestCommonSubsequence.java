// Problem Statement: Given two strings, find the length of their longest common subsequence (LCS).
// Logic: This problem can be solved using Dynamic Programming by maintaining a 2D array where each cell dp[i][j] represents the length of LCS of the substrings str1[0..i-1] and str2[0..j-1]. 


public class longestCommonSubsequence {
    public static int LCS(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1]; // dp[i][j] will store the length of LCS of str1[0..i-1] and str2[0..j-1]

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; // Characters match, extend the LCS by 1
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // Characters don't match, take the max from either excluding current char of str1 or str2
                }
            }
        }
        return dp[n][m];
    }    
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int result = LCS(str1, str2);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*m) - where n and m are the lengths of the two strings. We fill up a 2D array of size (n+1)*(m+1).
// Space Complexity: O(n*m) - We use a 2D dp array of size (n+1)*(m+1) to store lengths of LCS for substrings.
