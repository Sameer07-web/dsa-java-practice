/*
Problem: Contains Duplicate

Difficulty: Easy

Source: LeetCode 217

Description:
Given an integer array nums, return true if any value
appears at least twice in the array, and return false
if every element is distinct.

Example 1:

Input:
nums = [1,2,3,1]

Output:
true

Example 2:

Input:
nums = [1,2,3,4]

Output:
false

Example 3:

Input:
nums = [1,1,1,3,3,4,3,2,4,2]

Output:
true

Pattern: HashSet / Duplicate Detection

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Create a HashSet.
2. Traverse the array.
3. If an element already exists in the set:
   - Duplicate found.
   - Return true.
4. Otherwise, add the element to the set.
5. If traversal completes, return false.
*/

import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
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

        boolean result = containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);

        sc.close();
    }
}