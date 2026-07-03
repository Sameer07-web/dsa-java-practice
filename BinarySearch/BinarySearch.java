
/*
Problem: Binary Search

Difficulty: Easy

Source: LeetCode 704

Description:
Given an array of integers nums which is sorted in ascending order,
and an integer target, return the index of target if it exists.
Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input:
nums = [-1,0,3,5,9,12]
target = 9

Output:
4

Example 2:

Input:
nums = [-1,0,3,5,9,12]
target = 2

Output:
-1

Pattern: Classic Binary Search

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize:
   - left = 0
   - right = nums.length - 1
2. While left <= right:
   - Calculate mid.
   - If nums[mid] equals target, return mid.
   - If nums[mid] is smaller, search the right half.
   - Otherwise, search the left half.
3. If target is not found, return -1.
*/

import java.util.Scanner;

public class BinarySearch {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
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

        int result = search(nums, target);

        System.out.println("Target Index: " + result);

        sc.close();
    }
}

