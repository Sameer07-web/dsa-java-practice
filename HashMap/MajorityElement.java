/*
Problem: Majority Element

Difficulty: Easy

Source: LeetCode 169

Description:
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than
⌊n / 2⌋ times.

You may assume that the majority element always exists
in the array.

Example 1:

Input:
nums = [3,2,3]

Output:
3

Example 2:

Input:
nums = [2,2,1,1,1,2,2]

Output:
2

Pattern: Boyer-Moore Voting Algorithm

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Initialize candidate and count.
2. Traverse the array:
   - If count becomes 0, select current element as candidate.
   - If current element equals candidate, increment count.
   - Otherwise, decrement count.
3. The final candidate will be the majority element.
*/

import java.util.Scanner;

public class MajorityElement {

    public static int majorityElement(int[] nums) {

        int candidate = 0;
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

        return candidate;
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

        int result = majorityElement(nums);

        System.out.println("Majority Element: " + result);

        sc.close();
    }
}