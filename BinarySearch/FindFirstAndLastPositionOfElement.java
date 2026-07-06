/*
Problem: Find First and Last Position of Element in Sorted Array

Difficulty: Medium

Source: LeetCode 34

Description:
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.

If the target is not found, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input:
nums = [5,7,7,8,8,10]
target = 8

Output:
[3,4]

Example 2:

Input:
nums = [5,7,7,8,8,10]
target = 6

Output:
[-1,-1]

Pattern: Binary Search / Lower Bound / Upper Bound

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Perform Binary Search twice.
2. First search finds the first occurrence.
3. Second search finds the last occurrence.
4. Return both indices.
*/

import java.util.Scanner;

public class FindFirstAndLastPositionOfElement {

    public static int[] searchRange(int[] nums, int target) {

        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private static int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                ans = mid;
                right = mid - 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return ans;
    }

    private static int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                ans = mid;
                left = mid + 1;

            } else if (nums[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = searchRange(nums, target);

        System.out.println("First Position: " + result[0]);
        System.out.println("Last Position: " + result[1]);

        sc.close();
    }
}