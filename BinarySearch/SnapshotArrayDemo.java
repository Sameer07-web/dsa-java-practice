/*
Problem: Snapshot Array

Difficulty: Medium

Source: LeetCode 1146

Description:
Implement a SnapshotArray that supports the following operations:

1. SnapshotArray(int length)
2. void set(index, val)
3. int snap()
4. int get(index, snap_id)

The array remembers all previous values using snapshots.

Pattern: Binary Search + Design

Time Complexity:
set()  : O(1)
snap() : O(1)
get()  : O(log n)

Space Complexity:
O(total updates)

Approach:
1. Maintain a history list for every index.
2. Each history stores (snapId, value).
3. set():
   - Update the current snapshot if it already exists.
   - Otherwise, append a new entry.
4. snap():
   - Return the current snapshot id and increment it.
5. get():
   - Perform Binary Search to find the latest value
     whose snapshot id is less than or equal to
     the requested snapshot id.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnapshotArrayDemo {

    static class SnapshotArray {

        private List<int[]>[] snapshots;
        private int snapId;

        @SuppressWarnings("unchecked")
        public SnapshotArray(int length) {

            snapshots = new ArrayList[length];

            for (int i = 0; i < length; i++) {

                snapshots[i] = new ArrayList<>();
                snapshots[i].add(new int[]{0, 0});
            }

            snapId = 0;
        }

        public void set(int index, int val) {

            List<int[]> list = snapshots[index];

            if (list.get(list.size() - 1)[0] == snapId) {

                list.get(list.size() - 1)[1] = val;

            } else {

                list.add(new int[]{snapId, val});
            }
        }

        public int snap() {

            return snapId++;
        }

        public int get(int index, int snap_id) {

            List<int[]> list = snapshots[index];

            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (list.get(mid)[0] <= snap_id) {

                    left = mid + 1;

                } else {

                    right = mid - 1;
                }
            }

            return list.get(right)[1];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array length: ");
        int length = sc.nextInt();

        SnapshotArray snapshotArray = new SnapshotArray(length);

        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        while (operations-- > 0) {

            System.out.println("\nChoose Operation:");
            System.out.println("1. set");
            System.out.println("2. snap");
            System.out.println("3. get");

            String operation = sc.next();

            if (operation.equalsIgnoreCase("set")) {

                System.out.print("Index: ");
                int index = sc.nextInt();

                System.out.print("Value: ");
                int value = sc.nextInt();

                snapshotArray.set(index, value);

                System.out.println("Value Updated.");

            } else if (operation.equalsIgnoreCase("snap")) {

                int id = snapshotArray.snap();

                System.out.println("Snapshot ID: " + id);

            } else if (operation.equalsIgnoreCase("get")) {

                System.out.print("Index: ");
                int index = sc.nextInt();

                System.out.print("Snapshot ID: ");
                int snapId = sc.nextInt();

                int value = snapshotArray.get(index, snapId);

                System.out.println("Value: " + value);
            }
        }

        sc.close();
    }
}