/*
Problem: Maximum Difference in Array

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Keep track of minimum element seen so far.
2. Calculate difference between current element and minimum element.
3. Update maximum difference if needed.
4. Update minimum element.
*/

import java.util.Scanner;

public class MaximumDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int minElement = arr[0];
        int maxDifference = arr[1] - arr[0];

        for (int i = 1; i < n; i++) {
            int difference = arr[i] - minElement;
            if (difference > maxDifference) {
                maxDifference = difference;
            }
            if (arr[i] < minElement) {
                minElement = arr[i];
            }
        }
        System.out.println("Maximum Difference: " + maxDifference);
        sc.close();
    }
}