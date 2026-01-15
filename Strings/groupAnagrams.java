// Problem Statement: You are given an array of strings. You need to group words that are anagrams of each other.
// Logic: Two words are anagrams if they contain the same characters in the same frequency. So instead of comparing each word with every other word, we can sort the characters of each word and use the sorted version as a key in a hashmap. All words that map to the same key are anagrams of each other.

package Strings;

import java.util.*;

public class groupAnagrams {
    public static List<List<String>> groupAnagram(String[] strs){

        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            int[] freq = new int[26];

            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }
            String key = Arrays.toString(freq);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagram(strs);
        System.out.println(result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n*k), where n is the number of strings in the input and k is average word length.
// Space Complexity: O(n) for storing the output and the hashmap.
