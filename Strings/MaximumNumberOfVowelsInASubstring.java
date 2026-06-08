/*
Problem: Maximum Number of Vowels in a Substring of Given Length

Difficulty: Medium

Source: LeetCode 1456

Description:
Given a string s and an integer k,
return the maximum number of vowel letters
in any substring of s with length k.

Vowels are:
a, e, i, o, u

Example 1:
Input:
s = "abciiidef"
k = 3

Output:
3

Explanation:
Substring "iii" contains 3 vowels.

Example 2:
Input:
s = "aeiou"
k = 2

Output:
2

Example 3:
Input:
s = "leetcode"
k = 3

Output:
2

Pattern: Fixed Size Sliding Window

Time Complexity: O(n)

Space Complexity: O(1)

Approach:
1. Count vowels in the first window of size k.
2. Store count as current maximum.
3. Slide the window one position at a time.
4. Add incoming character if vowel.
5. Remove outgoing character if vowel.
6. Update maximum count.
7. Return maximum vowels found.
*/

import java.util.Scanner;

public class MaximumNumberOfVowelsInASubstring {

    public static int maxVowels(String s, int k) {

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        maxCount = count;

        for (int i = k; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }

            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' ||
               ch == 'i' || ch == 'o' ||
               ch == 'u';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        System.out.println("Maximum Vowels: "
                + maxVowels(s, k));

        sc.close();
    }
}