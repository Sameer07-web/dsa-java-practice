/*
Problem: Find Duplicate File in System

Difficulty: Medium

Source: LeetCode 609

Description:
Given a list of directory information including directory paths,
file names, and file contents, return all groups of duplicate files.

A group of duplicate files consists of at least two file paths
that have exactly the same content.

Example:

Input:

[
"root/a 1.txt(abcd) 2.txt(efgh)",
"root/c 3.txt(abcd)",
"root/c/d 4.txt(efgh)",
"root 4.txt(efgh)"
]

Output:

[
["root/a/1.txt","root/c/3.txt"],
["root/a/2.txt","root/c/d/4.txt","root/4.txt"]
]

Pattern: HashMap + String Parsing

Time Complexity: O(n × m)

n = number of directory strings
m = average length of each string

Space Complexity: O(n)

Approach:
1. Create a HashMap:
   Content -> List of file paths.
2. Parse each directory string.
3. Extract:
   - Directory path
   - File name
   - File content
4. Store the complete file path using the content as the key.
5. Return only those groups containing more than one file.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FindDuplicateFileInSystem {

    public static List<List<String>> findDuplicate(String[] paths) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String path : paths) {

            String[] parts = path.split(" ");

            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {

                String file = parts[i];

                int left = file.indexOf('(');
                int right = file.indexOf(')');

                String fileName = file.substring(0, left);
                String content = file.substring(left + 1, right);

                String fullPath = directory + "/" + fileName;

                map.putIfAbsent(content, new ArrayList<>());

                map.get(content).add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> files : map.values()) {

            if (files.size() > 1) {
                result.add(files);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of directory entries: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] paths = new String[n];

        System.out.println("Enter directory entries:");

        for (int i = 0; i < n; i++) {
            paths[i] = sc.nextLine();
        }

        List<List<String>> result = findDuplicate(paths);

        System.out.println("Duplicate File Groups:");

        for (List<String> group : result) {
            System.out.println(group);
        }

        sc.close();
    }
}