/*
Problem: Search in Rotated Sorted Array

Difficulty: Medium

Source: LeetCode 33

Description:
There is an integer array nums sorted in ascending order
(with distinct values).

Before being passed to your function, nums is possibly rotated
at an unknown pivot index.

Given the array nums after the possible rotation and an integer
target, return the index of target if it exists.
Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input:
nums = [4,5,6,7,0,1,2]
target = 0

Output:
4

Example 2:

Input:
nums = [4,5,6,7,0,1,2]
target = 3

Output:
-1

Pattern: Binary Search on Rotated Sorted Array

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize left and right pointers.
2. Perform Binary Search.
3. If nums[mid] equals target, return mid.
4. Determine which half is sorted.
5. Check if the target lies in the sorted half.
6. Search the appropriate half.
7. If the target is not found, return -1.
*/

import java.util.Scanner;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter rotated sorted array elements:");

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