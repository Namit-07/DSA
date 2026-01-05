// Problem Statement: Given an array of integers, move all the zeros to the end of the array while maintaining the relative order of the non-zero elements.
// Logic: Use two pointers to track the position of non-zero elements and fill the array accordingly.

public class moveZeros {
    public static void moveZeros(int[] arr){
        int j = 0; // Pointer for the position of the next non-zero element

        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args){
        int [] arr = {0, 1, 0, 3, 12};

        moveZeros(arr);
        
        for(int num : arr){
            System.out.print(num + " ");
        } 
    }
}
    
// Complexity Analysis
// Time Complexity: O(n) - We traverse the array once to move the zeros.
// Space Complexity: O(1) - No extra space is used.



