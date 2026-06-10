/*
Problem: Reorganize String

Difficulty: Medium

Source: LeetCode 767

Description:
Given a string s, rearrange the characters of s so that
no two adjacent characters are the same.

Return any possible rearrangement of s or return an
empty string if not possible.

Example 1:
Input:
s = "aab"

Output:
"aba"

Example 2:
Input:
s = "aaab"

Output:
""

Pattern: Greedy + Priority Queue (Max Heap)

Time Complexity: O(n log 26)

Space Complexity: O(26)

Approach:
1. Count frequency of each character.
2. Store characters in a max heap based on frequency.
3. Repeatedly take the two most frequent characters.
4. Append them to the result.
5. Decrease their frequencies and reinsert if needed.
6. Handle the final remaining character.
7. Return the reorganized string.
*/

import java.util.PriorityQueue;
import java.util.Scanner;

public class ReorganizeString {

    public static String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < 26; i++) {

            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() > 1) {

            int[] first = pq.poll();
            int[] second = pq.poll();

            result.append((char) (first[0] + 'a'));
            result.append((char) (second[0] + 'a'));

            first[1]--;
            second[1]--;

            if (first[1] > 0) {
                pq.offer(first);
            }

            if (second[1] > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {

            int[] last = pq.poll();

            if (last[1] > 1) {
                return "";
            }

            result.append((char) (last[0] + 'a'));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.println("Reorganized String: "
                + reorganizeString(s));

        sc.close();
    }
}