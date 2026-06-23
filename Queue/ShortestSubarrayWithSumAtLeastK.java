/*
Problem: Shortest Subarray with Sum at Least K

Difficulty: Hard

Source: LeetCode 862

Description:
Given an integer array nums and an integer k,
return the length of the shortest non-empty subarray
of nums with a sum of at least k.

If there is no such subarray, return -1.

Example 1:

Input:
nums = [1]
k = 1

Output:
1

Example 2:

Input:
nums = [1,2]
k = 4

Output:
-1

Example 3:

Input:
nums = [2,-1,2]
k = 3

Output:
3

Explanation:
The entire array [2,-1,2] has sum = 3.

Pattern: Monotonic Queue + Prefix Sum

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Compute prefix sums.
2. Use a deque to store indices of increasing prefix sums.
3. If current prefix sum - smallest prefix sum >= k:
   - Update minimum length.
   - Remove from front.
4. Remove larger prefix sums from the back because
   they are never useful.
5. Maintain the deque in increasing order.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ShortestSubarrayWithSumAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {

            while (!deque.isEmpty()
                    && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {

                minLength = Math.min(
                        minLength,
                        i - deque.pollFirst()
                );
            }

            while (!deque.isEmpty()
                    && prefixSum[i] <= prefixSum[deque.peekLast()]) {

                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE
                ? -1
                : minLength;
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = shortestSubarray(nums, k);

        System.out.println("Shortest Subarray Length: "
                + result);

        sc.close();
    }
}