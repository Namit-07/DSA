// Problem Statement: You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, but adjacent houses have security systems connected, so you cannot rob two adjacent houses. What is the maximum amount of money you can rob tonight without alerting the police?
// Logic: This problem can be solved using Dynamic Programming by recognizing that for each house, you have two choices: either rob it and add its value to the maximum amount robbed from all houses before the previous one, or skip it and take the maximum amount robbed from the previous house.

import java.util.*;

public class houseRobber {
    public static int rob(int[] nums){
        if(nums.length==0) return 0; // Base case: No houses to rob
        if(nums.length==1) return nums[0]; // Base case: Only one house to rob

        int prev2 = nums[0]; // Max amount robbed up to the house before the previous one
        int prev1 = Math.max(nums[0], nums[1]); // Max amount robbed up to the previous house

        for(int i=2; i<nums.length; i++){
            int curr = Math.max(prev1, nums[i] + prev2); 
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of houses: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the amount of money in each house:");
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int result = rob(nums);
        System.out.println("Maximum amount of money that can be robbed: " + result);
        sc.close();
    }
}

// Complexity Analysis:
// Time Complexity: O(n) - We iterate through the list of houses once.
// Space Complexity: O(1) - We use only a constant amount of extra space.
