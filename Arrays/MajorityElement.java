/*
Problem: Majority Element

Difficulty: Easy

Source: LeetCode 169

Description:
Given an array nums of size n, return the majority element.

The majority element is the element that appears
more than n / 2 times.

You may assume that the majority element always exists
in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Pattern: Boyer-Moore Voting Algorithm

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Maintain a candidate and count.
2. If count becomes 0, choose current element as candidate.
3. If current element equals candidate, increment count.
4. Otherwise decrement count.
5. The final candidate is the majority element.
*/

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println("Majority Element: " + candidate);
        sc.close();
    }
}