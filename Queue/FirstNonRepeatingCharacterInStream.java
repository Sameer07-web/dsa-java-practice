/*
Problem: First Non-Repeating Character in Stream

Difficulty: Medium

Source: Interview Problem

Description:
Given a stream of characters, find the first non-repeating
character at each point in the stream.

For every character added to the stream:
- Print the first non-repeating character.
- If no such character exists, print '#'.

Example:

Input:
stream = "aabc"

Output:
"a#bb"

Explanation:
'a'   -> a
'aa'  -> #
'aab' -> b
'aabc'-> b

Pattern: Queue + Hashing + Stream Processing

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Use a queue to store candidate non-repeating characters.
2. Use a frequency array to count occurrences.
3. For each character:
   - Increase frequency.
   - Push into queue.
4. Remove characters from the front while their frequency
   is greater than 1.
5. The front of the queue is the first non-repeating character.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingCharacterInStream {

    public static String firstNonRepeating(String stream) {

        int[] frequency = new int[26];

        Queue<Character> queue = new LinkedList<>();

        StringBuilder result = new StringBuilder();

        for (char ch : stream.toCharArray()) {

            frequency[ch - 'a']++;

            queue.offer(ch);

            while (!queue.isEmpty()
                    && frequency[queue.peek() - 'a'] > 1) {

                queue.poll();
            }

            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character stream: ");
        String stream = sc.nextLine();

        String result = firstNonRepeating(stream);

        System.out.println(
                "First Non-Repeating Characters: "
                        + result);

        sc.close();
    }
}