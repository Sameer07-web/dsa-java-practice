/*
Problem: Two Sum

Difficulty: Easy

Source: LeetCode 1

Description:
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up
to the target.

You may assume that each input would have exactly one
solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input:
nums = [2,7,11,15]
target = 9

Output:
[0,1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9

Example 2:

Input:
nums = [3,2,4]
target = 6

Output:
[1,2]

Pattern: HashMap / Complement Search

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Create a HashMap to store number and its index.
2. Traverse the array.
3. For each element:
   - Find complement = target - current element.
4. If complement exists in the HashMap:
   - Return both indices.
5. Otherwise, store current number and index.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                return new int[] {
                        map.get(complement),
                        i
                };
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println("Indices: "
                + Arrays.toString(result));

        sc.close();
    }
}