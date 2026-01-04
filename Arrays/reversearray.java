// Reverse an array
// Logic - Swap first and last elements, then move towards the center going through the array

import java.util.Arrays;
import java.util.Scanner;

public class reversearray{
    public static void main(String[]args){

        // Imitializing Scanner for input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        // Taking input of the array
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        // Reversing the array
        int start = 0;
        int end = n-1;

        while(start<end){
            // Swapping elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Moving towards the center
            start++;
            end--;
        }

        // Printing the reversed array
        System.out.println("Reversed array: " + Arrays.toString(arr));


    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse half of the array to reverse it.
// Space Complexity: O(1) - No extra space is used, we are reversing the array in place.