// Problem Statement: Given an array of strings, find the longest common prefix among them.
// Logic: Use a vertical scanning approach, comparing characters of each string at the same index until a mismatch is found.

public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){

        if(strs == null || strs.length == 0){
            return "";
        }

        String first = strs[0];

        for(int i=0; i<first.length(); i++){
            char ch = first.charAt(i);

            for( int j=1; j<strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};
        String[] strs3 = {"interspecies", "interstellar", "interstate"};

        System.out.println(longestCommonPrefix(strs1)); // "fl"
        System.out.println(longestCommonPrefix(strs2)); // ""
        System.out.println(longestCommonPrefix(strs3)); // "inters"
    }
}

// Complexity Analysis
// Time Complexity: O(n*m) - where n is the number of strings and m is the length of the longest common prefix
// Space Complexity: O(1) - We use constant space for variables.
