// Problem Statement: Given an array of integers, find the k largest elements in the array.
// Logic: We can use a min-heap (priority queue) to keep track of the k largest elements. We iterate through the array, adding elements to the heap. If the size of the heap exceeds k, we remove the smallest element. At the end, the heap will contain the k largest elements.

import java.util.PriorityQueue;

public class kLargestElementInArray {
    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.add(num);

            if(minHeap.size() > k){
                minHeap.poll(); // Remove the smallest element
            }
        }
        return minHeap.peek(); // The root of the min-heap is the k-th largest element
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        int kthLargest = findKthLargest(nums, k);
        System.out.println(k + "th largest element is: " + kthLargest); // Output: 5
    }
}

// Complexity Analysis:
// Time Complexity: O(N log k), where N is the number of elements in the array. Each insertion and deletion operation in the heap takes O(log k) time, and we perform these operations N times.
// Space Complexity: O(k), as we are storing k elements in the heap.
