// Problem Statement: Given an array nums of n integers where n > 1, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
// Logic: Use two auxiliary arrays to store the products of all elements to the left and right of each index, then multiply these two arrays to get the final result.

public class productExceptSelf {
    public static int[] productExceptSelf(int[]nums){

        int n = nums.length;
        int[] result = new int[n];

        // Left products
        result[0] = 1;
        for(int i=1; i<n; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        // Right products
        int rightProduct = 1;
        for(int i=n-1; i>=0; i--){
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);

        for(int num : res){
            System.out.println(num + " ");
        }
    }
}

// Complexity Ananlysis
// Time Complexity: O(n) - We traverse the array a constant number of times.
// Space Complexity: O(1) - We use the output array for storing results, and only a few extra variables.
