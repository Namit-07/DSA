// Problem Statement: Given an array of integers, return the k most frequent elements in the array.
// Logic: Use hashmap to count frequencies, then use a max-heap (priority queue) to extract the k most frequent elements.

import java.util.*;

public class topKFrequentElements{
    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Min-heap based on frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for(int num : freqMap.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll(); // Remove least frequent
            }
        }
        // Extract k most frequent elements
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = minHeap.poll();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] topK = topKFrequent(nums, k);
        System.out.println(Arrays.toString(topK)); // Output: [2, 1]
    }
}

// Complexity Analysis:
// Time Complexity: O(N log k), where N is the number of elements in the array. We traverse the array to build the frequency map (O(N)), and then we add each unique element to the heap (O(N log k)).
// Space Complexity: O(N) for the frequency map and O(k) for the heap, resulting in O(N) overall in the worst case.
