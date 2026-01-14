// Problem Statement: Given a string s and a string t, find the minimum window in s which will contain all the characters in t.
// Logic: We need all characater of t inside a window in s. Use HashMap to track required frequencies. Expand window until valid then shrink from left to find minimum valid window.

package Strings;

import java.util.HashMap;

public class minimumWindowSubstring {
    public static String minWindow(String s, String t){

        if(s.length()==0 || t.length()==0)
            return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0; 
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right<s.length()){
            char rChar = s.charAt(right);
            if(map.containsKey(rChar)){
                if(map.get(rChar)>0){
                    required--;
                }
                map.put(rChar, map.get(rChar) - 1);
            }
            right++;

            // Shrinking window
            while(required==0){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                char lChar = s.charAt(left);
                if(map.containsKey(lChar)){
                    map.put(lChar, map.get(lChar) + 1);
                    if(map.get(lChar)>0){
                        required++;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("The minimum window substring is: " + result);
    }
}


// Complexity Analysis:
// Time Complexity: O(n), where n is the length of string s. Each character is processed at most twice (once added and once removed).
// Space Complexity: O(m), where m is the number of unique characters in string t.