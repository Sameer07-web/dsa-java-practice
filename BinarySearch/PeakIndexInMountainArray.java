/*
Problem: Peak Index in a Mountain Array

Difficulty: Medium

Source: LeetCode 852

Description:
An array arr is a mountain array if:

1. arr.length >= 3
2. There exists an index i such that:
   - arr[0] < arr[1] < ... < arr[i]
   - arr[i] > arr[i+1] > ... > arr[arr.length-1]

Return the index of the peak element.

You must solve it in O(log n) time complexity.

Example 1:

Input:
arr = [0,1,0]

Output:
1

Example 2:

Input:
arr = [0,2,5,3,1]

Output:
2

Example 3:

Input:
arr = [0,10,5,2]

Output:
1

Pattern: Binary Search / Peak Finding

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize:
   - left = 0
   - right = arr.length - 1
2. Perform Binary Search.
3. Compare arr[mid] and arr[mid + 1].
4. If arr[mid] < arr[mid + 1]:
   - We are on the increasing slope.
   - Move left = mid + 1.
5. Otherwise:
   - We are on the decreasing slope or at the peak.
   - Move right = mid.
6. When left == right, it points to the peak index.
*/

import java.util.Scanner;

public class PeakIndexInMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {

                left = mid + 1;

            } else {

                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter mountain array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = peakIndexInMountainArray(arr);

        System.out.println("Peak Index: " + result);

        sc.close();
    }
}