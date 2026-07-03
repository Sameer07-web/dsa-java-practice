/*
Problem: Search Insert Position

Difficulty: Easy

Source: LeetCode 35

Description:
Given a sorted array of distinct integers and a target value,
return the index if the target is found.

If not, return the index where it would be inserted
to maintain the sorted order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input:
nums = [1,3,5,6]
target = 5

Output:
2

Example 2:

Input:
nums = [1,3,5,6]
target = 2

Output:
1

Example 3:

Input:
nums = [1,3,5,6]
target = 7

Output:
4

Pattern: Classic Binary Search / Lower Bound

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize:
   - left = 0
   - right = nums.length - 1
2. Perform Binary Search.
3. If target is found, return its index.
4. If target is greater, search the right half.
5. Otherwise, search the left half.
6. If target is not found, left will point to
   the correct insertion position.
*/

import java.util.Scanner;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

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

        return left;
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

        int result = searchInsert(nums, target);

        System.out.println("Insert Position: " + result);

        sc.close();
    }
}