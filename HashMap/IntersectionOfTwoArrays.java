/*
Problem: Intersection of Two Arrays

Difficulty: Easy

Source: LeetCode 349

Description:
Given two integer arrays nums1 and nums2,
return an array of their intersection.

Each element in the result must be unique and
you may return the result in any order.

Example 1:

Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Output:
[2]

Example 2:

Input:
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

Output:
[9,4]

Pattern: HashSet / Set Intersection

Time Complexity: O(n + m)

Space Complexity: O(n)

Approach:
1. Store all elements of nums1 in a HashSet.
2. Traverse nums2.
3. If an element exists in the HashSet:
   - Add it to another HashSet (resultSet).
4. HashSet automatically removes duplicates.
5. Convert the result set into an array.
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1,
                                     int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {

            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];

        int index = 0;

        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        int[] nums1 = new int[n];

        System.out.println("Enter first array elements:");

        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int[] nums2 = new int[m];

        System.out.println("Enter second array elements:");

        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        int[] result = intersection(nums1, nums2);

        System.out.println("Intersection Array: "
                + Arrays.toString(result));

        sc.close();
    }
}