/*
Problem: Longest Subarray With Sum K

Difficulty: Medium

Source: GeeksforGeeks

Description:
Given an array of integers and an integer K,
find the length of the longest subarray whose sum is equal to K.

Example 1:
Input:
arr = [10, 5, 2, 7, 1, 9]
K = 15

Output:
4

Explanation:
Subarray [5, 2, 7, 1] has sum 15.

Example 2:
Input:
arr = [-1, 2, 3]
K = 6

Output:
0

Pattern: Prefix Sum + HashMap

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
1. Maintain running prefix sum.
2. Store first occurrence of each prefix sum.
3. Check if (prefixSum - K) exists.
4. Update maximum length whenever a valid subarray is found.
5. Return maximum length.
*/

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarraySumK {
    public static int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == k) {
                maxLength = i + 1;
            }

            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLength = Math.max(maxLength, length);
            }
            map.putIfAbsent(prefixSum, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K: ");
        int k = sc.nextInt();

        System.out.println(
                "Longest Subarray Length: "
                + longestSubarray(arr, k));

        sc.close();
    }
}