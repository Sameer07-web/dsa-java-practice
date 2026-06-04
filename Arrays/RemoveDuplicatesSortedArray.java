/*
Problem: Remove Duplicates From Sorted Array

Difficulty: Easy

Source: LeetCode 26

Description:
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element
appears only once.

The relative order of the elements should be kept the same.

Return the number of unique elements in the array.

Example 1:
Input: nums = [1,1,2]
Output: 2

Explanation:
The first two elements become [1,2].

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5

Explanation:
The first five elements become [0,1,2,3,4].

Pattern: Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Keep the first element as unique.
2. Use an index pointer to track the position of the next unique element.
3. Traverse the array from the second element.
4. If the current element is different from the previous element,
   place it at the index position.
5. Increment the index.
6. The index value represents the count of unique elements.
*/

import java.util.Scanner;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int index = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < index; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nNumber of unique elements: " + index);
        sc.close();
    }
}