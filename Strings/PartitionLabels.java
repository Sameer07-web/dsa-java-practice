/*
Problem: Partition Labels

Difficulty: Medium

Source: LeetCode 763

Description:
You are given a string s.

Partition the string into as many parts as possible
so that each letter appears in at most one part.

Return a list of integers representing the size
of these parts.

Example 1:
Input:
s = "ababcbacadefegdehijhklij"

Output:
[9, 7, 8]

Explanation:
The partitions are:
"ababcbaca"
"defegde"
"hijhklij"

Example 2:
Input:
s = "eccbbbbdec"

Output:
[10]

Pattern: Greedy

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Store the last occurrence of every character.
2. Traverse the string.
3. Continuously update the current partition end.
4. When current index reaches partition end:
   - Partition is complete.
   - Store its size.
5. Return all partition sizes.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String s) {

        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(end,
                    lastIndex[s.charAt(i) - 'a']);

            if (i == end) {

                result.add(end - start + 1);

                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        List<Integer> result = partitionLabels(s);

        System.out.println("Partition Sizes: " + result);

        sc.close();
    }
}