/*
Problem: Constrained Subsequence Sum

Difficulty: Hard

Source: LeetCode 1425

Description:
Given an integer array nums and an integer k, return the
maximum sum of a non-empty subsequence of that array such that
for every two consecutive integers in the subsequence,
nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number
of elements (can be zero) from the array, leaving the remaining
elements in their original order.

Example 1:

Input:
nums = [10,2,-10,5,20]
k = 2

Output:
37

Explanation:
The subsequence [10,2,5,20] has the maximum sum.

Example 2:

Input:
nums = [-1,-2,-3]
k = 1

Output:
-1

Pattern: Dynamic Programming + Monotonic Queue

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Let dp[i] represent the maximum subsequence sum ending at index i.
2. Use a deque to maintain indices having maximum dp values.
3. Remove indices outside the window [i-k, i-1].
4. Compute dp[i] using the maximum dp value in the deque.
5. Remove smaller dp values from the back to maintain decreasing order.
6. Store only positive dp values in the deque.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ConstrainedSubsequenceSum {

    public static int constrainedSubsetSum(int[] nums, int k) {

        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        int maxSum = dp[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {

            while (!deque.isEmpty()
                    && deque.peekFirst() < i - k) {

                deque.pollFirst();
            }

            dp[i] = nums[i];

            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i],
                        nums[i] + dp[deque.peekFirst()]);
            }

            maxSum = Math.max(maxSum, dp[i]);

            while (!deque.isEmpty()
                    && dp[deque.peekLast()] <= dp[i]) {

                deque.pollLast();
            }

            if (dp[i] > 0) {
                deque.offerLast(i);
            }
        }

        return maxSum;
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

        int result = constrainedSubsetSum(nums, k);

        System.out.println("Maximum Constrained Subsequence Sum: "
                + result);

        sc.close();
    }
}