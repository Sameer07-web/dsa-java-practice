/*
Problem: Reverse String

Difficulty: Easy

Source: LeetCode 344

Description:
Write a function that reverses a string.

The input string is given as an array of characters.
You must modify the input array in-place with O(1) extra memory.

Example 1:
Input:
['h','e','l','l','o']

Output:
['o','l','l','e','h']

Example 2:
Input:
['H','a','n','n','a','h']

Output:
['h','a','n','n','a','H']

Pattern: Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Initialize two pointers:
   left = 0
   right = length - 1

2. Swap characters at left and right.

3. Move:
   left++
   right--

4. Continue until left >= right.
*/

import java.util.Scanner;

public class ReverseString {
    public static void reverse(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        reverse(arr);
        System.out.println("Reversed String: " + new String(arr));
        sc.close();
    }
}