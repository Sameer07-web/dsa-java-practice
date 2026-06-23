/*
Problem: Car Fleet

Difficulty: Medium

Source: LeetCode 853

Description:
There are n cars going to the same destination along a
one-lane road.

The destination is target miles away.

You are given two integer arrays:
1. position[i] -> current position of ith car.
2. speed[i] -> speed of ith car.

A car can never pass another car ahead of it, but it can
catch up and drive bumper to bumper at the slower car's speed.

A car fleet is a group of cars driving together.

Return the number of car fleets that will arrive at the destination.

Example 1:

Input:
target = 12

position = [10,8,0,5,3]
speed    = [2,4,1,1,3]

Output:
3

Explanation:

Car at 10 reaches in 1 hour.
Car at 8 reaches in 1 hour -> joins previous fleet.

Car at 5 reaches in 7 hours -> forms new fleet.
Car at 3 reaches in 3 hours -> joins fleet at position 5.

Car at 0 reaches in 12 hours -> forms new fleet.

Total Fleets = 3

Pattern: Sorting + Greedy

Time Complexity: O(n log n)

Space Complexity: O(n)

Approach:
1. Store position and speed together.
2. Sort cars in descending order of position.
3. Compute time taken by each car to reach target.
4. Traverse from nearest car to farthest car.
5. If current car takes more time than previous fleet:
   - Form a new fleet.
6. Otherwise:
   - Join the existing fleet.
*/

import java.util.Arrays;
import java.util.Scanner;

public class CarFleet {

    public static int carFleet(int target,
                               int[] position,
                               int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {

            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars,
                (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double previousTime = 0;

        for (int[] car : cars) {

            double currentTime =
                    (double) (target - car[0]) / car[1];

            if (currentTime > previousTime) {

                fleets++;
                previousTime = currentTime;
            }
        }

        return fleets;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter target distance: ");
        int target = sc.nextInt();

        System.out.print("Enter number of cars: ");
        int n = sc.nextInt();

        int[] position = new int[n];
        int[] speed = new int[n];

        System.out.println("Enter positions:");

        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }

        System.out.println("Enter speeds:");

        for (int i = 0; i < n; i++) {
            speed[i] = sc.nextInt();
        }

        int result = carFleet(target, position, speed);

        System.out.println("Number of Fleets: " + result);

        sc.close();
    }
}