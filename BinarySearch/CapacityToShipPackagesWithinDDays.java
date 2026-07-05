/*
Problem: Capacity To Ship Packages Within D Days

Difficulty: Medium

Source: LeetCode 1011

Description:
A conveyor belt has packages that must be shipped from one port
to another within the given number of days.

The ith package has a weight of weights[i].

Each day, packages are loaded onto the ship in the given order.

Return the least weight capacity of the ship that will result
in all the packages being shipped within the given days.

Pattern: Binary Search on Answer

Time Complexity: O(n log S)

n = number of packages
S = sum of all package weights

Space Complexity: O(1)

Approach:
1. Minimum capacity is the maximum package weight.
2. Maximum capacity is the sum of all package weights.
3. Apply Binary Search on ship capacity.
4. Simulate shipping for each capacity.
5. If shipping is possible within the given days:
   - Try a smaller capacity.
6. Otherwise:
   - Increase the capacity.
7. Return the minimum valid capacity.
*/

import java.util.Scanner;

public class CapacityToShipPackagesWithinDDays {

    public static int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {

        int requiredDays = 1;
        int currentWeight = 0;

        for (int weight : weights) {

            if (currentWeight + weight > capacity) {

                requiredDays++;
                currentWeight = 0;
            }

            currentWeight += weight;
        }

        return requiredDays <= days;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packages: ");
        int n = sc.nextInt();

        int[] weights = new int[n];

        System.out.println("Enter package weights:");

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter number of days: ");
        int days = sc.nextInt();

        int result = shipWithinDays(weights, days);

        System.out.println("Minimum Ship Capacity: " + result);

        sc.close();
    }
}