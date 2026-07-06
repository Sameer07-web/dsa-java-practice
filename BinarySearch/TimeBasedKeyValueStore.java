/*
Problem: Time Based Key-Value Store

Difficulty: Medium

Source: LeetCode 981

Description:
Design a time-based key-value data structure that can store
multiple values for the same key at different timestamps and
retrieve the value associated with a key at a given timestamp.

Implement the TimeMap class:

1. TimeMap() Initializes the object.
2. void set(String key, String value, int timestamp)
3. String get(String key, int timestamp)

If there are multiple values with timestamps less than or equal
to the given timestamp, return the value with the largest timestamp.
If no such value exists, return an empty string.

Pattern: HashMap + Binary Search

Time Complexity:
set() : O(1)
get() : O(log n)

Space Complexity: O(n)

Approach:
1. Use a HashMap to store each key with a list of (timestamp, value) pairs.
2. Since timestamps are inserted in increasing order, the list remains sorted.
3. For get():
   - Perform Binary Search on timestamps.
   - Find the largest timestamp less than or equal to the given timestamp.
4. Return the corresponding value.
*/

import java.util.*;

public class TimeBasedKeyValueStore {

    static class Entry {

        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    static class TimeMap {

        private Map<String, List<Entry>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(new Entry(timestamp, value));
        }

        public String get(String key, int timestamp) {

            if (!map.containsKey(key)) {
                return "";
            }

            List<Entry> list = map.get(key);

            int left = 0;
            int right = list.size() - 1;

            String result = "";

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (list.get(mid).timestamp <= timestamp) {

                    result = list.get(mid).value;
                    left = mid + 1;

                } else {

                    right = mid - 1;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TimeMap timeMap = new TimeMap();

        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        while (operations-- > 0) {

            System.out.print("Enter operation (set/get): ");
            String operation = sc.next();

            if (operation.equalsIgnoreCase("set")) {

                System.out.print("Enter key: ");
                String key = sc.next();

                System.out.print("Enter value: ");
                String value = sc.next();

                System.out.print("Enter timestamp: ");
                int timestamp = sc.nextInt();

                timeMap.set(key, value, timestamp);

                System.out.println("Value stored successfully.");

            } else if (operation.equalsIgnoreCase("get")) {

                System.out.print("Enter key: ");
                String key = sc.next();

                System.out.print("Enter timestamp: ");
                int timestamp = sc.nextInt();

                String result = timeMap.get(key, timestamp);

                System.out.println("Value: " + result);
            }
        }

        sc.close();
    }
}