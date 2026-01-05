// Problem Statement: Given an array, rotate the array to the right by k steps, where k is non-negative.
// Logic: Reverse parts of the array to achieve the rotation.

public class rotateArray{
    
    static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int k = 2;
        int n = arr.length;

        k = k % n; // In case k is greater than n

        reverse(arr, 0, n-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);

        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}

// Complexity Analysis
// Time Complexity: O(n) - We perform three reversals, each taking O(n)
// Space Complexity: O(1) - No extra space is used.