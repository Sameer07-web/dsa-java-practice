/*
Problem: String Compression

Difficulty: Medium

Source: LeetCode 443

Description:
Given an array of characters chars, compress it using
the following algorithm:

Begin with an empty string s.

For each group of consecutive repeating characters:
- If the group's length is 1, append the character.
- Otherwise, append the character followed by the count.

The compressed string is stored back into the input array.

Return the new length of the array after compression.

Example 1:
Input:
['a','a','b','b','c','c','c']

Output:
6

Compressed:
['a','2','b','2','c','3']

Example 2:
Input:
['a']

Output:
1

Example 3:
Input:
['a','b','b','b','b','b','b','b','b','b','b','b','b']

Output:
4

Compressed:
['a','b','1','2']

Pattern: Two Pointers

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Traverse the character array.
2. Count consecutive occurrences of a character.
3. Store the character once.
4. If count > 1, store count as characters.
5. Return the compressed length.
*/

import java.util.Scanner;

public class StringCompression {

    public static int compress(char[] chars) {

        int index = 0;
        int i = 0;

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            chars[index++] = current;

            if (count > 1) {

                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        char[] chars = input.toCharArray();

        int length = compress(chars);

        System.out.println("Compressed Length: " + length);

        System.out.print("Compressed String: ");

        for (int i = 0; i < length; i++) {
            System.out.print(chars[i]);
        }

        sc.close();
    }
}