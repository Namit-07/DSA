// Problem Statement: Given an array of integers, find the second largest element.
// Logic - Traverse the array to find the largest and second largest elements. 
import java.util.Scanner;


public class secondLargestElement {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
         System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
    
        if (n < 2) {
            System.out.println("Array should have at least two elements.");
            return;
        }

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest = arr[i];
            }
        }

        if(secondLargest == Integer.MIN_VALUE){
            System.out.println("There is no second largest element.");
        }else{
            System.out.println("The second largest element is: " + secondLargest);
        }
        
    }    
}

// Time Complexity: O(n) - We traverse the array once to find the largest and second largest elements.
// Space Complexity: O(1) - No extra data structures are used, only a fixed number of variables.
