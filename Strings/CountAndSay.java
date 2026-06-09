/*
Problem: Count and Say

Difficulty: Medium

Source: LeetCode 38

Description:
The count-and-say sequence is a sequence of digit strings
defined by the recursive formula:

countAndSay(1) = "1"

To generate the next term,
read off the digits of the previous term,
counting the number of digits in groups.

Example:
1      -> "1"
11     -> one 1
21     -> two 1s
1211   -> one 2, one 1
111221 -> one 1, one 2, two 1s

Example 1:
Input:
n = 4

Output:
"1211"

Example 2:
Input:
n = 1

Output:
"1"

Pattern: String Construction / Simulation

Time Complexity: O(2^n)

Space Complexity: O(2^n)

Approach:
1. Start with "1".
2. Generate next sequence from previous sequence.
3. Count consecutive characters.
4. Append count and character.
5. Repeat until nth sequence.
6. Return final sequence.
*/

import java.util.Scanner;

public class CountAndSay {

    public static String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder current = new StringBuilder();

            int count = 1;

            for (int j = 1; j < result.length(); j++) {

                if (result.charAt(j) == result.charAt(j - 1)) {

                    count++;

                } else {

                    current.append(count);
                    current.append(result.charAt(j - 1));

                    count = 1;
                }
            }

            current.append(count);
            current.append(result.charAt(result.length() - 1));

            result = current.toString();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Count And Say Sequence: "
                + countAndSay(n));

        sc.close();
    }
}