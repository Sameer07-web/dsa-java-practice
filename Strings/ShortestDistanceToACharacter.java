/*
Problem: Shortest Distance to a Character

Difficulty: Easy

Source: LeetCode 821

Description:
Given a string s and a character c that occurs in s,
return an array of integers answer where answer[i]
is the shortest distance from index i to the character c.

Example 1:
Input:
s = "loveleetcode"
c = 'e'

Output:
[3,2,1,0,1,0,0,1,2,2,1,0]

Example 2:
Input:
s = "aaab"
c = 'b'

Output:
[3,2,1,0]

Pattern: Two Pass Traversal

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Traverse from left to right.
2. Store distance from nearest occurrence on left.
3. Traverse from right to left.
4. Store distance from nearest occurrence on right.
5. Take minimum distance for each index.
6. Return result array.
*/

import java.util.Scanner;
import java.util.Arrays;

public class ShortestDistanceToACharacter {

    public static int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] result = new int[n];

        int prev = -n;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == c) {
                prev = i;
            }

            result[i] = i - prev;
        }

        prev = 2 * n;

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == c) {
                prev = i;
            }

            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter character: ");
        char c = sc.next().charAt(0);

        int[] result = shortestToChar(s, c);

        System.out.println("Shortest Distances: "
                + Arrays.toString(result));

        sc.close();
    }
}