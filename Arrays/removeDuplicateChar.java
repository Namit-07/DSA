// Problem Statement: Given a string, remove duplicate characters while maintaining the order of their first occurrence.
// Logic: Use a hash set to track seen characters and a StringBuilder to build the result string.

import java.util.HashSet;

public class removeDuplicateChar{
    public static String removeDuplicates(String str){
        
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for(char ch : str.toCharArray()){
            if(!seen.contains(ch)){
                seen.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
}
public static void main(String[] args) {
        System.out.println(removeDuplicates("programming"));
    }   
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the string once.
// Space Complexity: O(n) - In the worst case, all characters are unique and stored in the hash set.