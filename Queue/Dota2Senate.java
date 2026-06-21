/*
Problem: Dota2 Senate

Difficulty: Medium

Source: LeetCode 649

Description:
In the Dota2 senate, there are two parties:

1. Radiant (R)
2. Dire (D)

Each senator can:

- Ban one senator from the opposing party.
- Announce victory if all remaining senators belong
  to the same party.

Given a string senate representing the senators,
predict which party will finally announce victory.

Example 1:

Input:
"RD"

Output:
"Radiant"

Explanation:
Radiant senator bans Dire senator.

Example 2:

Input:
"RDD"

Output:
"Dire"

Explanation:
After several rounds, Dire wins.

Pattern: Queue Simulation / Round-Based Processing

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Store indices of Radiant senators in one queue.
2. Store indices of Dire senators in another queue.
3. Compare front senators:
   - Smaller index acts first and bans the other.
4. The surviving senator enters the next round:
   - Add index + n to the queue.
5. Continue until one queue becomes empty.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dota2Senate {

    public static String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {

            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() &&
                !dire.isEmpty()) {

            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {

                radiant.offer(rIndex + n);

            } else {

                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty()
                ? "Dire"
                : "Radiant";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter senate string (R/D): ");
        String senate = sc.nextLine();

        System.out.println("Winning Party: "
                + predictPartyVictory(senate));

        sc.close();
    }
}