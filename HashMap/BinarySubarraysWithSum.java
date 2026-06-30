/*
Problem: Binary Subarrays With Sum

Difficulty: Medium

Source: LeetCode 930

Description:
Given a binary array nums and an integer goal,
return the number of non-empty subarrays with a sum equal to goal.

A subarray is a contiguous part of the array.

Example 1:

Input:
nums = [1,0,1,0,1]
goal = 2

Output:
4

Explanation:
The 4 subarrays are:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]

Example 2:

Input:
nums = [0,0,0,0,0]
goal = 0

Output:
15

Pattern: Prefix Sum + HashMap

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a HashMap to store:
   Prefix Sum -> Frequency.
2. Initialize:
   map.put(0, 1)
   to handle subarrays starting from index 0.
3. Traverse the array:
   - Update prefix sum.
   - Check if (prefixSum - goal) exists.
   - If yes, add its frequency to the answer.
4. Store the current prefix sum in the HashMap.
*/

import java.util.HashMap;
import java.util.Scanner;

public class BinarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            if (map.containsKey(prefixSum - goal)) {
                count += map.get(prefixSum - goal);
            }

            map.put(prefixSum,
                    map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
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

        System.out.print("Enter goal: ");
        int goal = sc.nextInt();

        int result = numSubarraysWithSum(nums, goal);

        System.out.println("Number of Subarrays: " + result);

        sc.close();
    }
}