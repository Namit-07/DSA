// Problem Statement: Given a string, count the frequency of each character in the string.
// Logic: Use a hash map to store the frequency of each character as we traverse the string.

import java.util.HashMap;
import java.util.Scanner;

public class charFrequency {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to count character frequency: ");
        String str = sc.nextLine();

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(char ch : str.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Character frequencies: " + freqMap);
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the entire string once to count frequencies.
// Space Complexity: O(n) - Hashmap stores characters and their frequencies.