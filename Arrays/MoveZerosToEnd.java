/*
Problem: Move Zeros To End

Pattern: Two Pointers

Time Complexity: O(n)
Space Complexity: O(1)

Approach:
1. Maintain index for next non-zero element.
2. Traverse the array.
3. Whenever a non-zero element is found, swap it with the current index.
4. Increment index.
*/

import java.util.Scanner;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                index++;
            }
        }
        System.out.println("Array after moving zeros to end:");

        for (int num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}