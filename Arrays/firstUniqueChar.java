// Problem Statement: Given a string, find the first non-repeating character in it and return its index. If it does not exist, return -1.
// Logic: Use a hashmap to store the frequency of each character in the string. Then, iterate through the string again to find the first character with a frequency of 1.

import java.util.*;

public class firstUniqueChar {
    public static int firstUniqChar(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        // First pass: count frequency of each character
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Second pass: find the first unique character
        for (int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1; // No unique character found
    }
    public static void main(String[] args) {
        String s= "leetcode"; // '0'
        s= "loveleetcode"; // '2'
        System.out.println("Index of first unique character: " + firstUniqChar(s));
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the length of the string. We traverse the string twice.
// Space Complexity: O(1), since the character set is fixed (e.g., lowercase English letters), the hashmap will have at most 26 entries.