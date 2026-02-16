// Problem Statement: Koko loves to eat bananas. There are n piles of bananas, the i-th pile has piles[i] bananas. The guards have gone and will come back in h hours. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead, and won't eat any more bananas during that hour. Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return. Return the minimum integer k such that she can eat all the bananas within h hours.
// Logic: We can use binary search to find the minimum eating speed k. The minimum speed is 1 banana per hour, and the maximum speed is the size of the largest pile. We will check if Koko can eat all bananas at a given speed k within h hours. If she can, we will try a smaller speed; if she cannot, we will try a larger speed.

public class kokoBananas {
    public static int minEatingSpeed(int[] piles, int h){
        int left = 1;
        int right = 0;

        // Find the maximum number of bananas in any pile to set the upper bound for binary search
        for(int p : piles){
            right = Math.max(right, p); // The maximum speed is the size of the largest pile
        }

        // Binary search to find the minimum eating speed
        while(left < right){
            int mid = left + (right - left)/2; // Calculate the middle speed
            if(canFinish(piles, h, mid)){
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Try a larger speed
            }
        }
        return left; // Return the minimum eating speed
    }
    static boolean canFinish(int[] piles, int h, int speed){
        int hoursNeeded = 0;
        for(int p : piles){
            hoursNeeded += (p + speed - 1) / speed; // Calculate hours needed for each pile
        }
        return hoursNeeded <= h; // Check if Koko can finish within h hours
    }
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}

// Complexity Analysis:
// Time Complexity: O(n log m), where n is the number of piles and m is the maximum number of bananas in a pile. The binary search runs in O(log m) and for each speed, we check if Koko can finish in O(n).
// Space Complexity: O(1) for the binary search and O(n) for the input array.