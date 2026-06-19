/*
Problem: Next Greater Element I

Difficulty: Easy

Source: LeetCode 496

Description:
The next greater element of an element x in nums1 is the
first greater element that appears to the right of x in nums2.

Given two distinct integer arrays nums1 and nums2,
where nums1 is a subset of nums2, return an array
containing the next greater element for each element in nums1.

If no greater element exists, return -1.

Example 1:

Input:
nums1 = [4,1,2]
nums2 = [1,3,4,2]

Output:
[-1,3,-1]

Example 2:

Input:
nums1 = [2,4]
nums2 = [1,2,3,4]

Output:
[3,-1]

Pattern: Monotonic Decreasing Stack

Time Complexity: O(n + m)

Space Complexity: O(m)

Approach:
1. Traverse nums2.
2. Maintain a decreasing stack.
3. Whenever current element is greater than stack top:
   - Pop stack.
   - Store next greater element in HashMap.
4. Push current element into stack.
5. Build result for nums1 using the HashMap.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementI {

    public static int[] nextGreaterElement(
            int[] nums1,
            int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {

            while (!stack.isEmpty()
                    && stack.peek() < num) {

                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            result[i] =
                    map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of nums1: ");
        int n = sc.nextInt();

        int[] nums1 = new int[n];

        System.out.println("Enter nums1 elements:");

        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of nums2: ");
        int m = sc.nextInt();

        int[] nums2 = new int[m];

        System.out.println("Enter nums2 elements:");

        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] result =
                nextGreaterElement(nums1, nums2);

        System.out.println("Result: "
                + Arrays.toString(result));

        sc.close();
    }
}