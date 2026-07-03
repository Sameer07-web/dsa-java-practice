/*
Problem: Guess Number Higher or Lower

Difficulty: Easy

Source: LeetCode 374

Description:
We are playing the Guess Game.

I pick a number from 1 to n.
You have to guess which number I picked.

Every time you guess wrong, I will tell you whether
the picked number is higher or lower.

Return the picked number.

The guess API is already defined.

Example:

Input:
n = 10
pick = 6

Output:
6

Pattern: Classic Binary Search

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize:
   - left = 1
   - right = n
2. Find the middle number.
3. Call the guess(mid) API.
4. If:
   - guess(mid) == 0, return mid.
   - guess(mid) == 1, search the right half.
   - guess(mid) == -1, search the left half.
5. Continue until the number is found.
*/

/* The GuessGame class is provided by LeetCode.

class GuessGame {
    int guess(int num);
}
*/

public class GuessNumberHigherOrLower extends GuessGame {

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            }

            if (result == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}