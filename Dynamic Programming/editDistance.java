// Problem Statement: Given two strings, find the minimum number of operations required to convert one string into the other. The allowed operations are insertion, deletion, and substitution of a single character. (Levenshtein Distance)
// Logic: This problem can be solved using Dynamic Programming by maintaining a 2D array where each cell dp[i][j] represents the minimum edit distance between the first i characters of str1 and the first j characters of str2. We consider the costs of insertion, deletion, and substitution to fill up the dp table.

public class editDistance {
    public static int minDistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1]; // dp[i][j] will store the minimum edit distance between s1[0..i-1] and s2[0..j-1]

        // Base cases: converting empty string to another string
        for(int i=0; i<=n; i++){
            dp[i][0] = i; // Deleting all characters from s1 to match empty s2
        } 
        for(int j=0; j<=m; j++){
            dp[0][j] = j; // Inserting all characters of s2 to match empty s1
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; // Characters match, no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], // Substitution
                                        Math.min(dp[i-1][j],   // Deletion
                                                 dp[i][j-1])); // Insertion
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int result = minDistance(s1, s2);
        System.out.println("Minimum Edit Distance: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*m) - where n and m are the lengths of the two strings. We fill up a 2D array of size (n+1)*(m+1).
// Space Complexity: O(n*m) - We use a 2D dp array of size (n+1)*(m+1) to store minimum edit distances for substrings.