/*
Problem: Longest Consecutive Sequence

Difficulty: Medium

Source: LeetCode 128

Description:
Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input:
nums = [100,4,200,1,3,2]

Output:
4

Explanation:
The longest consecutive sequence is [1,2,3,4].
Therefore, its length is 4.

Example 2:

Input:
nums = [0,3,7,2,5,8,4,6,0,1]

Output:
9

Pattern: HashSet / Sequence Detection

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Store all elements in a HashSet.
2. For each element:
   - Check if it is the start of a sequence.
   - A number is the start if (num - 1) is not present.
3. If it is a start:
   - Continue checking num + 1, num + 2, ...
4. Keep track of the maximum sequence length.
*/

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {

                    currentNum++;
                    currentStreak++;
                }

                longest = Math.max(longest, currentStreak);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = longestConsecutive(nums);

        System.out.println("Longest Consecutive Sequence Length: "
                + result);

        sc.close();
    }
}