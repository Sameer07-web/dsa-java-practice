/*
Problem: Group Anagrams

Difficulty: Medium

Source: LeetCode 49

Description:
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging
the letters of a different word or phrase, typically
using all the original letters exactly once.

Example 1:

Input:
strs = ["eat","tea","tan","ate","nat","bat"]

Output:
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]

Example 2:

Input:
strs = [""]

Output:
[[""]]

Example 3:

Input:
strs = ["a"]

Output:
[["a"]]

Pattern: HashMap + Sorting + Grouping

Time Complexity: O(n * k log k)

n = number of strings
k = average length of each string

Space Complexity: O(n * k)

Approach:
1. Create a HashMap:
   - Key -> Sorted version of string.
   - Value -> List of anagrams.
2. For each string:
   - Convert it to a character array.
   - Sort the array.
   - Use the sorted string as the key.
3. Add the original string to the corresponding list.
4. Return all grouped lists.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[n];

        System.out.println("Enter strings:");

        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        List<List<String>> result = groupAnagrams(strs);

        System.out.println("Grouped Anagrams:");

        for (List<String> group : result) {
            System.out.println(group);
        }

        sc.close();
    }
}