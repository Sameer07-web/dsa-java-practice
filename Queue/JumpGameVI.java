/*
Problem: Jump Game VI

Difficulty: Medium

Source: LeetCode 1696

Description:
You are given a 0-indexed integer array nums and an integer k.

You are initially standing at index 0. In one move, you can
jump at most k steps forward without going outside the boundaries
of the array.

Your score is the sum of all nums[j] for each visited index j.

Return the maximum score you can get.

Example 1:

Input:
nums = [1,-1,-2,4,-7,3]
k = 2

Output:
7

Explanation:
Choose the path:
1 -> -1 -> 4 -> 3

Score = 1 + (-1) + 4 + 3 = 7

Example 2:

Input:
nums = [10,-5,-2,4,0,3]
k = 3

Output:
17

Pattern: Dynamic Programming + Monotonic Queue

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Let dp[i] represent the maximum score to reach index i.
2. For each index i, we can jump from any index in [i-k, i-1].
3. Use a deque to maintain indices with maximum dp values.
4. Remove indices that are outside the current window.
5. Use the front of the deque to compute dp[i].
6. Remove smaller dp values from the back to maintain
   decreasing order.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class JumpGameVI {

    public static int maxResult(int[] nums, int k) {

        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);

        for (int i = 1; i < n; i++) {

            while (!deque.isEmpty()
                    && deque.peekFirst() < i - k) {

                deque.pollFirst();
            }

            dp[i] = dp[deque.peekFirst()] + nums[i];

            while (!deque.isEmpty()
                    && dp[deque.peekLast()] <= dp[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n - 1];
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

        int result = maxResult(nums, k);

        System.out.println("Maximum Score: " + result);

        sc.close();
    }
}