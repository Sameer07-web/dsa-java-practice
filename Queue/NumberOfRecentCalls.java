/*
Problem: Number of Recent Calls

Difficulty: Easy

Source: LeetCode 933

Description:
You have a RecentCounter class which counts the number
of recent requests within a certain time frame.

Implement the RecentCounter class:

1. RecentCounter() Initializes the counter.
2. ping(int t) Adds a new request at time t, where t
   represents some time in milliseconds, and returns the
   number of requests that have happened in the past
   3000 milliseconds (inclusive).

Specifically, return the number of requests in the range
[t - 3000, t].

Example:

Input:
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

Output:
[null, 1, 2, 3, 3]

Explanation:
ping(1)    -> 1
ping(100)  -> 2
ping(3001) -> 3
ping(3002) -> 3

Pattern: Queue / Sliding Window

Time Complexity:
ping() -> O(1) amortized

Space Complexity: O(n)

Approach:
1. Maintain a queue storing recent request times.
2. Insert the current request time into the queue.
3. Remove all requests older than (t - 3000).
4. The remaining queue size represents recent calls.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfRecentCalls {

    static class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {

            queue.offer(t);

            while (!queue.isEmpty()
                    && queue.peek() < t - 3000) {

                queue.poll();
            }

            return queue.size();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RecentCounter recentCounter =
                new RecentCounter();

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        System.out.println("Enter request times:");

        for (int i = 0; i < n; i++) {

            int time = sc.nextInt();

            System.out.println(
                    "Recent Calls Count: "
                    + recentCounter.ping(time));
        }

        sc.close();
    }
}