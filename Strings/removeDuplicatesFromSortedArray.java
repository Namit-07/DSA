// Problem Statement: Given a sorted array, remove duplicates in-place such that each unique element appears once. Return the number of unique elements.
// Logic: i=index of the last unique element. J scans through the array. When nums[j]!=nums[i], we found a new unique element, increment i and update nums[i]=nums[j].

package Strings;

public class removeDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums){
        
        if(nums.length==0)
            return 0;

        int i=0; //index of last unique element

        for(int j=1; j<nums.length; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1; //number of unique elements
    }    
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.print("Array after removing duplicates: ");

        for(int i=0; i<k; i++){
            System.out.print(nums[i] + " ");
        }
    }
}

// Complexity Analysis:
// Time complexity: O(n), where n is the number of elements in the array. We traverse the array once.
// Space complexity: O(1), since we are modifying the array in place and not using any extra space.
