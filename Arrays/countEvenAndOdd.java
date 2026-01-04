// Problem Statement: Given an array of integers, count the number of even and odd elements in the array.
// Logic: Traverse the array and use counters to keep track of even and odd numbers.
import java.util.Scanner;

public class countEvenAndOdd {
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int evenCount = 0;
        int oddCount = 0;

        for(int i=0; i<n; i++){
            if(arr[i] % 2 == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Number of even elements: " + evenCount);
        System.out.println("Number of odd elements: " + oddCount);
    }  
}
// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once to count even and odd elements.
// Space Complexity: O(1) - No extra space is used, only counters are maintained.
