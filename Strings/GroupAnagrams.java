/*
Problem: Group Anagrams

Difficulty: Medium

Source: LeetCode 49

Description:
Given an array of strings strs, group the anagrams together.

You can return the answer in any order.

An Anagram is a word formed by rearranging the letters
of another word using all the original letters exactly once.

Example 1:
Input:
["eat","tea","tan","ate","nat","bat"]

Output:
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]

Example 2:
Input:
[""]

Output:
[
 [""]
]

Example 3:
Input:
["a"]

Output:
[
 [a]
]

Pattern: HashMap + Sorting

Time Complexity: O(n × k log k)

n = number of strings
k = average string length

Space Complexity: O(n × k)

Approach:
1. Create a HashMap where:
   Key   = Sorted String
   Value = List of Anagrams

2. Traverse each string in the array.

3. Convert string to character array.

4. Sort the character array.

5. Convert sorted array back to string.

6. Use sorted string as key.

7. Add original string to corresponding list.

8. Return all grouped anagrams.
*/

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

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