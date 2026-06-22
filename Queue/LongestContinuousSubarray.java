/*
Problem: Longest Continuous Subarray With Absolute Diff
Less Than or Equal to Limit

Difficulty: Medium

Source: LeetCode 1438

Description:
Given an array of integers nums and an integer limit,
return the size of the longest non-empty subarray such that
the absolute difference between any two elements of this
subarray is less than or equal to limit.

Example 1:

Input:
nums = [8,2,4,7]
limit = 4

Output:
2

Explanation:
The longest valid subarrays are [2,4] and [4,7].

Example 2:

Input:
nums = [10,1,2,4,7,2]
limit = 5

Output:
4

Explanation:
The longest subarray is [2,4,7,2].

Pattern: Monotonic Queue + Sliding Window

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use two deques:
   - maxDeque stores indices in decreasing order.
   - minDeque stores indices in increasing order.
2. Expand the window using right pointer.
3. Front of maxDeque gives maximum element.
4. Front of minDeque gives minimum element.
5. If max - min > limit:
   - Shrink window from left.
6. Track the maximum valid window length.
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LongestContinuousSubarray {

    public static int longestSubarray(int[] nums,
                                      int limit) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] < nums[right]) {

                maxDeque.pollLast();
            }

            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] > nums[right]) {

                minDeque.pollLast();
            }

            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()]
                    - nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxLength = Math.max(maxLength,
                    right - left + 1);
        }

        return maxLength;
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

        System.out.print("Enter limit: ");
        int limit = sc.nextInt();

        int result = longestSubarray(nums, limit);

        System.out.println("Longest Valid Subarray Length: "
                + result);

        sc.close();
    }
}