/*
Problem: Top K Frequent Elements

Difficulty: Medium

Source: LeetCode 347

Description:
Given an integer array nums and an integer k,
return the k most frequent elements.

You may return the answer in any order.

Example 1:

Input:
nums = [1,1,1,2,2,3]
k = 2

Output:
[1,2]

Example 2:

Input:
nums = [1]
k = 1

Output:
[1]

Pattern: HashMap + Heap (Priority Queue)

Time Complexity: O(n log k)

Space Complexity: O(n)

Approach:
1. Use a HashMap to store the frequency of each element.
2. Use a Min Heap to keep track of the top k frequent elements.
3. If heap size exceeds k, remove the least frequent element.
4. Extract elements from the heap to form the result.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>(
                        (a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = topKFrequent(nums, k);

        System.out.println("Top K Frequent Elements: "
                + Arrays.toString(result));

        sc.close();
    }
}