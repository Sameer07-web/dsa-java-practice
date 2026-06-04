/*
Problem: Maximum Subarray

Difficulty: Medium

Source: LeetCode 53

Description:
Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum
and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6

Explanation:
Subarray [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Pattern: Kadane's Algorithm

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Initialize currentSum and maxSum with first element.
2. For each element:
   - Start a new subarray OR
   - Extend the existing subarray.
3. Update maxSum whenever a larger sum is found.
4. Return maxSum.
*/

import java.util.Scanner;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i],
                                  currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(
            "Maximum Subarray Sum: "
            + maxSubArray(nums)
        );
        sc.close();
    }
}