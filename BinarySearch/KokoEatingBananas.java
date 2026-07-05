/*
Problem: Koko Eating Bananas

Difficulty: Medium

Source: LeetCode 875

Description:
Koko loves to eat bananas.

There are n piles of bananas, where the ith pile has piles[i]
bananas.

The guards will return in h hours.

Find the minimum integer eating speed k such that Koko can
eat all the bananas within h hours.

Pattern: Binary Search on Answer

Time Complexity: O(n log m)

n = number of piles
m = maximum pile size

Space Complexity: O(1)

Approach:
1. The answer lies between:
   - Minimum speed = 1
   - Maximum speed = largest pile.
2. Apply Binary Search on the eating speed.
3. Calculate hours required for each speed.
4. If Koko can finish within h hours:
   - Try a smaller speed.
5. Otherwise:
   - Increase the speed.
6. Return the minimum valid speed.
*/

import java.util.Scanner;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {

        long hours = 0;

        for (int pile : piles) {

            hours += (pile + speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of piles: ");
        int n = sc.nextInt();

        int[] piles = new int[n];

        System.out.println("Enter bananas in each pile:");

        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        System.out.print("Enter available hours: ");
        int h = sc.nextInt();

        int result = minEatingSpeed(piles, h);

        System.out.println("Minimum Eating Speed: " + result);

        sc.close();
    }
}