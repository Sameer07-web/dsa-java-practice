/*
Problem: Find All Duplicates in an Array

Difficulty: Medium

Source: LeetCode 442

Description:
Given an integer array nums of length n where all integers
are in the range [1, n] and each integer appears once or twice,
return an array of all the integers that appear twice.

You must write an algorithm that runs in O(n) time and uses
only constant extra space.

Example 1:

Input:
nums = [4,3,2,7,8,2,3,1]

Output:
[2,3]

Example 2:

Input:
nums = [1,1,2]

Output:
[1]

Example 3:

Input:
nums = [1]

Output:
[]

Pattern: Array Marking / Index Mapping

Time Complexity: O(n)

Space Complexity: O(1) (excluding output list)

Approach:
1. Since numbers are in the range [1, n],
   use each number as an index.
2. For each element:
   - Compute index = abs(nums[i]) - 1.
3. If the value at that index is already negative:
   - The number is a duplicate.
4. Otherwise:
   - Mark it as visited by making it negative.
5. Return all duplicate numbers.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllDuplicatesInAnArray {

    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {

                duplicates.add(index + 1);

            } else {

                nums[index] = -nums[index];
            }
        }

        return duplicates;
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

        List<Integer> result = findDuplicates(nums);

        System.out.println("Duplicate Elements: " + result);

        sc.close();
    }
}