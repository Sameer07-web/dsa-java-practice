/*
Problem: Contiguous Array

Difficulty: Medium

Source: LeetCode 525

Description:
Given a binary array nums, return the maximum length of a
contiguous subarray with an equal number of 0 and 1.

Example 1:

Input:
nums = [0,1]

Output:
2

Explanation:
The entire array has one 0 and one 1.

Example 2:

Input:
nums = [0,1,0]

Output:
2

Pattern: Prefix Sum + HashMap

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Treat:
   - 0 as -1
   - 1 as +1
2. Maintain a running count:
   - count-- for 0
   - count++ for 1
3. If the same count appears again:
   - The subarray between those indices has equal
     number of 0s and 1s.
4. Store the first occurrence of each count in a HashMap.
5. Track the maximum subarray length.
*/

import java.util.HashMap;
import java.util.Scanner;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int count = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            if (map.containsKey(count)) {

                maxLength = Math.max(
                        maxLength,
                        i - map.get(count)
                );

            } else {

                map.put(count, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter binary array elements (0 or 1):");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findMaxLength(nums);

        System.out.println(
                "Maximum Length of Contiguous Array: "
                        + result);

        sc.close();
    }
}