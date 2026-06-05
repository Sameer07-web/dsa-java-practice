/*
Problem: Valid Palindrome

Difficulty: Easy

Source: LeetCode 125

Description:
A phrase is a palindrome if, after converting all uppercase
letters into lowercase letters and removing all non-alphanumeric
characters, it reads the same forward and backward.

Alphanumeric characters include letters and numbers.

Example 1:
Input:
"A man, a plan, a canal: Panama"

Output:
true

Example 2:
Input:
"race a car"

Output:
false

Example 3:
Input:
" "

Output:
true

Pattern: Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Initialize two pointers:
   left = 0
   right = length - 1

2. Skip non-alphanumeric characters.

3. Convert characters to lowercase.

4. Compare both characters.
   If not equal, return false.

5. Move pointers inward.

6. If all comparisons succeed,
   return true.
*/

import java.util.Scanner;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String str = sc.nextLine();

        boolean result = isPalindrome(str);
        System.out.println("Is Palindrome: " + result);
        sc.close();
    }
}