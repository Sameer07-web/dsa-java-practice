/*
Problem: First Bad Version

Difficulty: Easy

Source: LeetCode 278

Description:
You are a product manager and currently leading a team to
develop a new product.

Unfortunately, the latest version of your product fails the
quality check.

Since each version is developed based on the previous version,
all versions after a bad version are also bad.

Given n versions, find the first bad version.

The isBadVersion(version) API is already defined.

Example:

Input:
n = 5
firstBadVersion = 4

Output:
4

Pattern: Binary Search / Lower Bound

Time Complexity: O(log n)

Space Complexity: O(1)

Approach:
1. Initialize:
   - left = 1
   - right = n
2. Perform Binary Search.
3. If mid is a bad version:
   - The first bad version is at mid or before it.
   - Move right = mid.
4. Otherwise:
   - Search the right half.
   - Move left = mid + 1.
5. When left == right, return left.
*/

/* The VersionControl class is provided by LeetCode.

class VersionControl {
    boolean isBadVersion(int version);
}
*/

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}