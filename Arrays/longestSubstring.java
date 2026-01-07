// Problem Statement: Given a string, find the length of the longest substring without repeating characters.
// Logic: Use a sliding window approach with a hash set to track characters in the current substring.

import java.util.HashSet;


public class longestSubstring {
    public static int lenghtOfLongestSubstring(String s){

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right<s.length(); right++){
            char current = s.charAt(right);

            while(set.contains(current)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lenghtOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lenghtOfLongestSubstring("bbbbb")); // Output: 1
        System.out.println(lenghtOfLongestSubstring("pwwkew")); // Output: 3
    }
}

// Complexity Analysis
// Time Complexity: O(n) - Each character is added and removed at most once.
// Space Complexity: O(min(m, n)) - HashSet stores window characters.

