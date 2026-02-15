// Problem Statement: Given n activities with their start and finish times, select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.
// Logic: This problem can be solved using a greedy algorithm. We first sort the activities based on their finish times. Then, we iterate through the sorted activities and select an activity if its start time is greater than or equal to the finish time of the last selected activity.

import java.util.*;

public class activitySelectionProblem {
    static class Activity{
        int start;
        int end;

        Activity(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public static int maxActivities(int[] start, int[] end){
        int n = start.length;
        Activity[] arr = new Activity[n];

        // Create an array of Activity objects
        for(int i=0; i<n; i++){
            arr[i] = new Activity(start[i], end[i]);
        }

        // Sort activities based on their finish times
        Arrays.sort(arr, (a,b)-> a.end - b.end);

        int count = 1; // Count of selected activities
        int lastEndTime = arr[0].end; // Finish time of the last selected activity

        // Iterate through the sorted activities and select the next activity if it starts after the last selected activity finishes
        for(int i=1; i<n; i++){
            if(arr[i].start >= lastEndTime){
                count++;
                lastEndTime = arr[i].end; // Update the finish time of the last selected activity
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        int result = maxActivities(start, end);
        System.out.println("Maximum number of activities that can be performed: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n log n) due to the sorting step. The rest of the algorithm runs in O(n) time.
// Space Complexity: O(n) for storing the activities in an array.
