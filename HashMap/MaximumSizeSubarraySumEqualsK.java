/*
Problem: Maximum Size Subarray Sum Equals K

Difficulty: Medium

Source: LeetCode 325

Description:
Given an integer array nums and an integer k,
return the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.

Example 1:

Input:
nums = [1,-1,5,-2,3]
k = 3

Output:
4

Explanation:
The subarray [1, -1, 5, -2] sums to 3 and has length 4.

Example 2:

Input:
nums = [-2,-1,2,1]
k = 1

Output:
2

Explanation:
The subarray [-1, 2] sums to 1 and has length 2.

Pattern: Prefix Sum + HashMap

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a HashMap to store:
   Prefix Sum -> First Occurrence Index.
2. Traverse the array while maintaining prefix sum.
3. If prefixSum == k:
   - Update maximum length to i + 1.
4. If (prefixSum - k) exists in the map:
   - A valid subarray exists.
5. Store only the first occurrence of each prefix sum
   because it gives the longest subarray.
*/

import java.util.HashMap;
import java.util.Scanner;

public class MaximumSizeSubarraySumEqualsK {

    public static int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            if (prefixSum == k) {
                maxLength = i + 1;
            }

            if (map.containsKey(prefixSum - k)) {

                maxLength = Math.max(
                        maxLength,
                        i - map.get(prefixSum - k)
                );
            }

            map.putIfAbsent(prefixSum, i);
        }

        return maxLength;
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

        int result = maxSubArrayLen(nums, k);

        System.out.println(
                "Maximum Length of Subarray: " + result);

        sc.close();
    }
}