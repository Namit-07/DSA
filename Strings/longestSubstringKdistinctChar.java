// Problem Statement: Given a string s and an integer k, find the length of the longest substring that contains at most k distinct characters.
// Logic: We can use the sliding window technique. We will maintain a window that expands by adding characters to the right and contracts by removing characters from the left when the number of distinct characters exceeds k. We will use a hashmap to keep track of the count of each character in the current window.

package Strings;

import java.util.HashMap;

public class longestSubstringKdistinctChar {
    public static int longestSubstringKDistinct(String s, int k){

        if(k==0 || s.length()==0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink the window from the left if we have more than k distinct characters
            while (map.size()>k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        int result = longestSubstringKDistinct(s, k);
        System.out.println("The length of the longest substring with at most " + k + " distinct characters is: " + result);
    }
}


// Complexity Analysis:
// Time Complexity: O(n), where n is the length of the string. Each character is processed at most twice (once added and once removed).
// Space Complexity: O(k), where k is the number of distinct characters allowed. 