/*
Problem: Split Array Largest Sum

Difficulty: Hard

Source: LeetCode 410

Description:
Given an integer array nums and an integer k, split the array
into k non-empty continuous subarrays.

Minimize the largest sum among these subarrays.

Return the minimized largest sum.

Pattern: Binary Search on Answer

Time Complexity: O(n log S)

n = number of elements
S = sum of all elements

Space Complexity: O(1)

Approach:
1. Minimum possible answer is the maximum element.
2. Maximum possible answer is the sum of all elements.
3. Apply Binary Search on the answer.
4. Greedily split the array for each candidate sum.
5. If the number of subarrays is within k:
   - Try a smaller maximum sum.
6. Otherwise:
   - Increase the maximum sum.
7. Return the minimum valid answer.
*/

import java.util.Scanner;

public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num > maxSum) {

                subarrays++;
                currentSum = 0;
            }

            currentSum += num;
        }

        return subarrays <= k;
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

        System.out.print("Enter number of subarrays (k): ");
        int k = sc.nextInt();

        int result = splitArray(nums, k);

        System.out.println("Minimum Largest Sum: " + result);

        sc.close();
    }
}