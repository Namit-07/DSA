// Problem Statement: Given n vertical lines, find two lines that together form a container that it holds the maximum amount of water.
// Logic: Use a two-pointer approach, starting with one pointer at the beginning and the other at the end of the array, and move them towards each other based on the heights of the lines.

package Strings;

public class containerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;

            maxArea = Math.max(maxArea, area);

            // move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println("Maximum Area: " + result); // Output: Maximum Area: 49
    }
}

// Complexity Analysis:
// Time Complexity: O(n), where n is the number of lines. We traverse the array with two pointers.
// Space Complexity: O(1), as we are using only a constant amount of extra space