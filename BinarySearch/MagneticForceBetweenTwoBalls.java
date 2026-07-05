/*
Problem: Magnetic Force Between Two Balls

Difficulty: Medium

Source: LeetCode 1552

Description:
In the universe Earth C-137, Rick discovered a special form
of magnetic force between two balls.

Given an integer array position where position[i] represents
the position of the ith basket and an integer m representing
the number of balls, return the largest minimum magnetic force
between any two balls.

Pattern: Binary Search on Answer + Greedy

Time Complexity: O(n log n + n log D)

n = number of baskets
D = maximum possible distance

Space Complexity: O(1)

Approach:
1. Sort the basket positions.
2. Minimum possible distance = 1.
3. Maximum possible distance = last position - first position.
4. Apply Binary Search on the answer.
5. For each candidate distance:
   - Greedily place the balls.
6. If all m balls can be placed:
   - Try a larger minimum distance.
7. Otherwise:
   - Reduce the distance.
8. Return the largest valid minimum distance.
*/

import java.util.Arrays;
import java.util.Scanner;

public class MagneticForceBetweenTwoBalls {

    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];

        while (left < right) {

            int mid = left + (right - left + 1) / 2;

            if (canPlace(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean canPlace(int[] position, int m, int distance) {

        int balls = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {

            if (position[i] - lastPosition >= distance) {

                balls++;
                lastPosition = position[i];

                if (balls >= m) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of baskets: ");
        int n = sc.nextInt();

        int[] position = new int[n];

        System.out.println("Enter basket positions:");

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }

        System.out.print("Enter number of balls: ");
        int m = sc.nextInt();

        int result = maxDistance(position, m);

        System.out.println("Maximum Minimum Distance: " + result);

        sc.close();
    }
}