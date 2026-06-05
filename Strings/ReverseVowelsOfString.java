/*
Problem: Reverse Vowels of a String

Difficulty: Easy

Source: LeetCode 345

Description:
Given a string s, reverse only all the vowels in the string
and return it.

The vowels are:
'a', 'e', 'i', 'o', 'u'
and can appear in both lower and upper cases.

Example 1:
Input:
hello

Output:
holle

Example 2:
Input:
leetcode

Output:
leotcede

Pattern: Two Pointers

Time Complexity: O(n)
Space Complexity: O(n)

Approach:
1. Convert the string into a character array.
2. Initialize two pointers:
   left = 0
   right = length - 1
3. Move left pointer until a vowel is found.
4. Move right pointer until a vowel is found.
5. Swap both vowels.
6. Continue until left >= right.
*/

import java.util.Scanner;

public class ReverseVowelsOfString {

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    }
    
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        System.out.println("Output: " + reverseVowels(str));
        sc.close();
    }
}