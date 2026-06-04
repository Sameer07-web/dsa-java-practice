/*
Problem: Product of Array Except Self

Difficulty: Medium

Source: LeetCode 238

Description:
Given an integer array nums, return an array answer
such that answer[i] is equal to the product of all
the elements of nums except nums[i].

You must solve it without using division
and in O(n) time complexity.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Pattern: Prefix Product + Suffix Product

Time Complexity: O(n)
Space Complexity: O(1) Extra Space

Approach:
1. Store prefix products in answer array.
2. Traverse from right to left maintaining suffix product.
3. Multiply prefix and suffix products.
4. Return the final answer array.
*/

import java.util.Scanner;
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int suffixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] result = productExceptSelf(nums);
        System.out.println("Product Array:");

        for (int num : result) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}