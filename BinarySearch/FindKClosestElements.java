/*
Problem: Find K Closest Elements

Difficulty: Medium

Source: LeetCode 658

Description:
Given a sorted integer array arr, two integers k and x,
return the k closest integers to x in the array.

The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
1. |a - x| < |b - x|
2. If the distances are equal, the smaller integer is preferred.

Pattern: Binary Search + Sliding Window

Time Complexity: O(log(n - k) + k)

Space Complexity: O(k)

Approach:
1. Binary Search the starting index of the window of size k.
2. Compare the distances:
   - x - arr[mid]
   - arr[mid + k] - x
3. Move the window accordingly.
4. Collect the k elements starting from the final window.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - k;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        List<Integer> result = findClosestElements(arr, k, x);

        System.out.println("K Closest Elements: " + result);

        sc.close();
    }
}