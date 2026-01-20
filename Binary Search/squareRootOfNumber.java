// Problem Statement: Given a non-negative integer x, return the floor of sqrt(x).
// Logic: Use binary search between 0 and x to find the largest mid such that mid*mid <= x.

public class squareRootOfNumber {
    public static int mySqrt(int x){
        
        if(x == 0 || x == 1){
            return x;
        }

        int left = 1, right = x, result = 0;

        while(left <= right){
            int mid = left + (right-left)/2;

            long sq = (long) mid * mid;

            if(sq == x){
                return mid;
            } else if(sq < x){
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int x = 8;
        int sqrt = mySqrt(x);

        System.out.println("Square root of " + x + " is: " + sqrt);
        System.out.println("Square root of 16 is: " + mySqrt(16));
    } 
}

// Complexity analysis: 
// Time complexity: O(log x), where x is the input number. The search space is halved each time.
// Space complexity: O(1), since we are using only a constant amount of extra space