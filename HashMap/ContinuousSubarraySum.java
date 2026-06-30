/*
Problem: Continuous Subarray Sum

Difficulty: Medium

Source: LeetCode 523

Description:
Given an integer array nums and an integer k,
return true if nums has a continuous subarray of size
at least two whose elements sum up to a multiple of k.

A subarray is continuous if it consists of consecutive elements.

An integer x is a multiple of k if there exists an integer n
such that x = n * k.

Example 1:

Input:
nums = [23,2,4,6,7]
k = 6

Output:
true

Explanation:
The subarray [2,4] sums to 6, and 6 is a multiple of 6.

Example 2:

Input:
nums = [23,2,6,4,7]
k = 6

Output:
true

Explanation:
The entire subarray [23,2,6,4,7] sums to 42,
and 42 is a multiple of 6.

Example 3:

Input:
nums = [23,2,6,4,7]
k = 13

Output:
false

Pattern: Prefix Sum + HashMap + Modulo Arithmetic

Time Complexity: O(n)

Space Complexity: O(min(n, k))

Approach:
1. Use a HashMap to store:
   Remainder -> First Occurrence Index.
2. Initialize:
   map.put(0, -1)
   to handle subarrays starting from index 0.
3. Traverse the array:
   - Compute running prefix sum.
   - Find remainder = prefixSum % k.
   - If the same remainder appeared before:
     The subarray sum between those indices is divisible by k.
   - Ensure subarray length is at least 2.
*/

import java.util.HashMap;
import java.util.Scanner;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            int remainder = prefixSum % k;

            if (map.containsKey(remainder)) {

                if (i - map.get(remainder) > 1) {
                    return true;
                }

            } else {

                map.put(remainder, i);
            }
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

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        boolean result = checkSubarraySum(nums, k);

        System.out.println("Continuous Subarray Exists: " + result);

        sc.close();
    }
}