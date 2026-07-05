/*
Problem: Minimum Days to Make m Bouquets

Difficulty: Medium

Source: LeetCode 1482

Description:
You are given an integer array bloomDay, an integer m,
and an integer k.

You need to make exactly m bouquets.

To make one bouquet, you need to use k adjacent flowers.

Each flower blooms on bloomDay[i].

Return the minimum number of days needed to make m bouquets.
If it is impossible, return -1.

Pattern: Binary Search on Answer

Time Complexity: O(n log M)

n = number of flowers
M = maximum bloom day

Space Complexity: O(1)

Approach:
1. If m × k > bloomDay.length, return -1.
2. The answer lies between the minimum and maximum bloom day.
3. Apply Binary Search on the number of days.
4. Count how many bouquets can be made for each day.
5. If enough bouquets can be formed:
   - Try a smaller day.
6. Otherwise:
   - Increase the number of days.
7. Return the minimum valid day.
*/

import java.util.Scanner;

public class MinimumDaysToMakeMBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int days) {

        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {

            if (bloom <= days) {

                flowers++;

                if (flowers == k) {

                    bouquets++;
                    flowers = 0;
                }

            } else {

                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of flowers: ");
        int n = sc.nextInt();

        int[] bloomDay = new int[n];

        System.out.println("Enter bloom days:");

        for (int i = 0; i < n; i++) {
            bloomDay[i] = sc.nextInt();
        }

        System.out.print("Enter number of bouquets (m): ");
        int m = sc.nextInt();

        System.out.print("Enter flowers per bouquet (k): ");
        int k = sc.nextInt();

        int result = minDays(bloomDay, m, k);

        System.out.println("Minimum Days: " + result);

        sc.close();
    }
}