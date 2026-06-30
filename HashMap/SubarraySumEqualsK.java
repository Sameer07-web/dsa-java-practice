/*
Problem: Subarray Sum Equals K

Difficulty: Medium

Source: LeetCode 560

Description:
Given an array of integers nums and an integer k,
return the total number of continuous subarrays whose
sum equals to k.

Example 1:

Input:
nums = [1,1,1]
k = 2

Output:
2

Explanation:
Subarrays:
[1,1] -> Sum = 2
[1,1] -> Sum = 2

Total = 2

Example 2:

Input:
nums = [1,2,3]
k = 3

Output:
2

Explanation:
Subarrays:
[1,2] -> Sum = 3
[3] -> Sum = 3

Pattern: Prefix Sum + HashMap

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a HashMap to store:
   Prefix Sum -> Frequency.
2. Initialize map with:
   map.put(0, 1)
   to handle subarrays starting from index 0.
3. Traverse the array:
   - Update prefix sum.
   - Check if (prefixSum - k) exists in the map.
   - If yes, add its frequency to the answer.
   - Store current prefix sum in the map.
*/

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
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

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of Subarrays: " + result);

        sc.close();
    }
}