/*
Problem: Leaders In Array

Difficulty: Easy

Source: GeeksforGeeks

Description:
Given an array arr[] of positive integers.

A leader is an element that is greater than or equal to
all the elements to its right side.

The rightmost element is always a leader.

Return all the leaders in the array.

Example 1:
Input: arr = [16,17,4,3,5,2]
Output: 17 5 2

Explanation:
17 is greater than all elements to its right.
5 is greater than 2.
2 is the rightmost element.

Example 2:
Input: arr = [1,2,3,4,5]
Output: 5

Pattern: Right To Left Traversal

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
1. Start from the last element.
2. Maintain the maximum element seen so far.
3. Traverse from right to left.
4. If current element is greater than or equal to maximum,
   it is a leader.
5. Store leaders and update maximum.
6. Reverse the result to maintain original order.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeadersInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> leaders = new ArrayList<>();
        int maxRight = arr[n - 1];
        leaders.add(maxRight);

        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] >= maxRight) {
                maxRight = arr[i];
                leaders.add(arr[i]);
            }
        }

        Collections.reverse(leaders);
        System.out.println("Leaders in array:");

        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
        sc.close();
    }
}