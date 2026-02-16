// Problem Statement: Given arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the railway station so that no train waits. We are given two arrays that represent arrival and departure times of trains that stop.
// Logic: This problem can be solved using a greedy algorithm. We can sort the arrival and departure times separately. Then, we can use two pointers to traverse both arrays and count the number of platforms needed at any time.

import java.util.*;

public class minimumNumberOfPlatforms {
    public static int findPlatform(int[] arr, int[] dep){
        
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0, j=0, platforms=0, maxPlatforms=0;

        while(i<arr.length && j<dep.length){
            if(arr[i] < dep[j]){
                // A train arrives before the next one departs, so we need a platform
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                i++;
            } 
            // A train departs before the next one arrives, so we can free a platform
            else {
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
    }
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println("Minimum number of platforms required: " + findPlatform(arr, dep));
    }
}

// Complexity Analysis:
// Time Complexity: O(n log n) due to the sorting step, where n is the number of trains.
// Space Complexity: O(1) if we ignore the space used for sorting, otherwise O(n) due to the sorting algorithm's space requirements.
