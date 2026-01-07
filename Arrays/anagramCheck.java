// Problem Statement: Given two strings, check if they are anagrams of each other.
// Logic: Use a hash map to count the frequency of each character in both strings and compare the maps.

import java.util.HashMap;

public class anagramCheck {
    public static boolean isAnagram(String str1, String str2){
        if (str1.length()!=str2.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters in s1
        for (char ch : str1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Reduce count using s2
        for(char ch : str2.toCharArray()){
            if(!map.containsKey(ch))
                return false;

                map.put(ch, map.get(ch) - 1);
            if(map.get(ch) < 0)
                return false; 
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("hello", "world"));
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse both strings once.
// Space Complexity: O(n) - Hashmap stores characters and their frequencies.
