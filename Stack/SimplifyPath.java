/*
Problem: Simplify Path

Difficulty: Medium

Source: LeetCode 71

Description:
Given an absolute path for a Unix-style file system,
simplify it and return the canonical path.

Rules:
1. "." refers to the current directory.
2. ".." refers to the parent directory.
3. Multiple consecutive slashes are treated as a single slash.
4. The canonical path must:
   - Start with a single slash.
   - Have directories separated by one slash.
   - Not end with a trailing slash.

Example 1:

Input:
/home/

Output:
/home

Example 2:

Input:
/../

Output:
/

Example 3:

Input:
/home//foo/

Output:
/home/foo

Example 4:

Input:
/a/./b/../../c/

Output:
/c

Pattern: Stack / Path Processing

Time Complexity: O(n)

Space Complexity: O(n)

Approach:
1. Split path using "/".
2. Ignore:
   - Empty strings ""
   - Current directory "."
3. For "..":
   - Move one directory back using pop().
4. Otherwise:
   - Push directory name into stack.
5. Build canonical path from stack.
*/

import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") ||
                    part.equals(".")) {

                continue;

            } else if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String directory : stack) {
            result.append("/").append(directory);
        }

        return result.length() == 0
                ? "/"
                : result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter path: ");
        String path = sc.nextLine();

        System.out.println("Simplified Path: "
                + simplifyPath(path));

        sc.close();
    }
}