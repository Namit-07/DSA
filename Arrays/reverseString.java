// Problem Statement: Given an array of characters, reverse the array in place.
// Logic: Use two pointers, one starting at the beginning and the other at the end of the array, and swap the characters until the pointers meet in the middle.     
import java.util.Scanner;


public class reverseString {
    public static void main(String[] args) {
        
        // String str = "Hello";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to reverse: ");
        String str = sc.nextLine();

        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while(left<right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        String reversed = new String(arr);
        System.out.println(reversed);
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We traverse half of the array to reverse it.
// Space Complexity: O(1) - No extra space is used.
