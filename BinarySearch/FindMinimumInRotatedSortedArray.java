/*
Problem: Find Minimum in Rotated Sorted Array

Difficulty: Medium

Source: LeetCode 153

Description:
Suppose an array of distinct integers is sorted in ascending
order and then rotated between 1 and n times.

Given the rotated sorted array, return the minimum element.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input:
nums = [3,4,5,1,2]

Output:
1

Example 2:

Input:
nums = [4,5,6,7,0,1,2]

Output:
0

Example 3:

Input:
nums = [11,13,15,17]

Output:
11

Pattern: Binary Search on Rotated Sorted Array

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize:
   - left = 0
   - right = nums.length - 1
2. Perform Binary Search.
3. Compare nums[mid] with nums[right].
4. If nums[mid] > nums[right]:
   - Minimum lies in the right half.
   - Move left = mid + 1.
5. Otherwise:
   - Minimum lies at mid or in the left half.
   - Move right = mid.
6. When left == right, it points to the minimum element.
*/

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {

                left = mid + 1;

            } else {

                right = mid;
            }
        }

        return nums[left];
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

        int result = findMin(nums);

        System.out.println("Minimum Element: " + result);

        sc.close();
    }
}