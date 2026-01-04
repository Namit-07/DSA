// Problem Statemnet: Given an array of integers, check if the array is sorted in asending order.
// Logic: Traverse the array and compare each element with the next one.

import java.util.Scanner;
 

public class arraySortedOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        boolean isSorted = true;

        for(int i=0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                isSorted = false;
                break;
            }
        }

        if(isSorted){
            System.out.println("The array is sorted.");
        } else {
            System.out.println("The array is not sorted.");
        }
     }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once to check if it is sorted.
// Space Complexity: O(1) - No extra space is used.
