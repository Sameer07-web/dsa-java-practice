/*
Problem: Sliding Window Maximum

Difficulty: Hard

Source: LeetCode 239

Description:
You are given an array of integers nums, and there is a
sliding window of size k moving from the very left of the
array to the very right.

You can only see the k numbers in the window.

Return the maximum value in each sliding window.

Example 1:

Input:
nums = [1,3,-1,-3,5,3,6,7]
k = 3

Output:
[3,3,5,5,6,7]

Explanation:

Window [1,3,-1]   -> 3
Window [3,-1,-3]  -> 3
Window [-1,-3,5]  -> 5
Window [-3,5,3]   -> 5
Window [5,3,6]    -> 6
Window [3,6,7]    -> 7

Example 2:

Input:
nums = [1]
k = 1

Output:
[1]

Pattern: Monotonic Queue / Sliding Window

Time Complexity: O(n)

Space Complexity: O(k)

Approach:
1. Use a deque to store indices.
2. Remove indices that are outside the current window.
3. Remove smaller elements from the back because
   they cannot become the maximum.
4. Add current index to the deque.
5. The front of the deque always contains the
   maximum element for the current window.
*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            while (!deque.isEmpty()
                    && nums[deque.peekLast()] <= nums[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Maximums in each window: "
                + Arrays.toString(result));

        sc.close();
    }
}