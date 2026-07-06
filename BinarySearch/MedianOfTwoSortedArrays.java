/*
Problem: Median of Two Sorted Arrays

Difficulty: Hard

Source: LeetCode 4

Description:
Given two sorted arrays nums1 and nums2 of size m and n,
return the median of the two sorted arrays.

The overall run time complexity should be O(log(min(m, n))).

Example 1:

Input:
nums1 = [1,3]
nums2 = [2]

Output:
2.0

Example 2:

Input:
nums1 = [1,2]
nums2 = [3,4]

Output:
2.5

Pattern: Binary Search on Partition

Time Complexity: O(log(min(m, n)))

Space Complexity: O(1)

Approach:
1. Always perform Binary Search on the smaller array.
2. Partition both arrays such that:
   - Left half contains half the elements.
   - Right half contains the remaining elements.
3. If the partition is valid:
   - For even total elements, return the average of the two middle values.
   - For odd total elements, return the maximum element on the left.
4. Otherwise, adjust the partition using Binary Search.
*/

import java.util.Scanner;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            int partitionX = left + (right - left) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionX - 1];

            int minRightX = (partitionX == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionX];

            int maxLeftY = (partitionY == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionY - 1];

            int minRightY = (partitionY == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((m + n) % 2 == 0) {

                    return ((double) Math.max(maxLeftX, maxLeftY)
                            + Math.min(minRightX, minRightY)) / 2.0;

                } else {

                    return Math.max(maxLeftX, maxLeftY);
                }

            } else if (maxLeftX > minRightY) {

                right = partitionX - 1;

            } else {

                left = partitionX + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int m = sc.nextInt();

        int[] nums1 = new int[m];

        System.out.println("Enter sorted elements of first array:");

        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n = sc.nextInt();

        int[] nums2 = new int[n];

        System.out.println("Enter sorted elements of second array:");

        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        double result = findMedianSortedArrays(nums1, nums2);

        System.out.println("Median: " + result);

        sc.close();
    }
}