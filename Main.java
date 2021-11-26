
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
    }

    // Kadane's Algorithms - create a subarray with the largest sum
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);

            // if the sum < 0 its better to reinitialize as negative numbers aren't going to
            // contribute to the max sum (only decrease it)
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    /**
     * Sliding Window Time Complexity = O(n)
     */
    public static boolean containsNearbyDuplicateSlidingWindow(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            // front of the window is i, the rear is k steps back
            // elements within the window are maintained using a set
            if (i > k)
                set.remove(nums[i - k - 1]); // if the counter surpasses the window size remove the first element
            // when add returns false it means the item cannot be added into the set as it
            // is a duplicate value and true can be returned
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }

    /**
     * Window Sliding Time Complexity = O(n)
     */
    public static int calculateMaxSux(int[] arr, int k) {
        int n = arr.length;
        int max_sum = 0;
        // array length must be bigger than window size
        if (n > k) {
            // sum of first window
            for (int i = 0; i < k; i++)
                max_sum += arr[i];

            // the sum of the first three elements has been previously calculated
            int window_sum = max_sum;
            for (int i = k; i < n; i++) {
                // calculate the sum of the current window
                // by adding the last element of this window
                // and subtracting the first element of the previous window
                window_sum += arr[i] - arr[i - k];
                max_sum = Math.max(max_sum, window_sum);

            }
        }
        return max_sum;
    }

    /**
     * HashSet Approach Time Complexity = O(n) Space Complexity = O(n)
     */
    public static boolean containsDuplicateHashSet(int[] a) {
        if (a.length > 1) {
            HashSet<Integer> found = new HashSet<Integer>();
            for (int i : a) {
                if (!found.contains(i))
                    found.add(i);
                else
                    return true;
            }
        }
        return false;
    }

    /**
     * Inline sort approach Time Complexity: O(n log n)
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length > 1) {
            Arrays.sort(nums);

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1])
                    return true;
            }
        }
        return false;
    }
}