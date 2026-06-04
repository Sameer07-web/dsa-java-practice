/*
Problem: Trapping Rain Water

Difficulty: Hard

Source: LeetCode 42

Description:
Given n non-negative integers representing an elevation map
where the width of each bar is 1, compute how much water
it can trap after raining.

Example 1:
Input:
height = [0,1,0,2,1,0,1,3,2,1,2,1]

Output:
6

Explanation:
The elevation map can trap 6 units of rainwater.

Example 2:
Input:
height = [4,2,0,3,2,5]

Output:
9

Pattern: Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Use two pointers: left and right.
2. Maintain leftMax and rightMax.
3. Move the pointer with smaller height.
4. Calculate trapped water using:
   water += maxHeight - currentHeight
5. Continue until pointers meet.
*/

import java.util.Scanner;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] height = new int[n];

        System.out.println("Enter elevation heights:");

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        System.out.println(
                "Trapped Water: " + trap(height));

        sc.close();
    }
}