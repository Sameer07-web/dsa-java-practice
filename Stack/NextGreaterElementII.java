/*
Problem: Next Greater Element II

Difficulty: Medium

Source: LeetCode 503

Description:
Given a circular integer array nums, return the next
greater number for every element in nums.

The next greater number of a number x is the first
greater number to its right while traversing the array
circularly.

If no greater element exists, return -1.

Example 1:

Input:
[1,2,1]

Output:
[2,-1,2]

Explanation:

1 -> Next greater is 2
2 -> No greater element
1 -> Circularly sees 2

Example 2:

Input:
[1,2,3,4,3]

Output:
[2,3,4,-1,4]

Pattern: Monotonic Decreasing Stack / Circular Array

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a monotonic decreasing stack.
2. Traverse the array twice to simulate circular traversal.
3. Pop smaller elements and assign their next greater element.
4. Push indices only during the first pass.
5. Remaining elements have no next greater element.
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int current = nums[i % n];

            while (!stack.isEmpty()
                    && nums[stack.peek()] < current) {

                result[stack.pop()] = current;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
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

        int[] result = nextGreaterElements(nums);

        System.out.println("Result: "
                + Arrays.toString(result));

        sc.close();
    }
}