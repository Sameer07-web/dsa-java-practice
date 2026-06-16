/*
Problem: LFU Cache

Difficulty: Hard

Source: LeetCode 460

Description:
Design and implement a data structure for a Least Frequently
Used (LFU) cache.

Implement the LFUCache class:

1. LFUCache(int capacity)
2. int get(int key)
3. void put(int key, int value)

When the cache reaches its capacity, it should invalidate
and remove the least frequently used key.

If multiple keys have the same frequency,
remove the least recently used key.

Both get() and put() must run in O(1) average time complexity.

Example:
Input:
LFUCache cache = new LFUCache(2);

cache.put(1,1);
cache.put(2,2);

cache.get(1);

cache.put(3,3);

cache.get(2);
cache.get(3);

cache.put(4,4);

cache.get(1);
cache.get(3);
cache.get(4);

Output:
1
-1
3
-1
3
4

Pattern: HashMap + Doubly Linked List + Frequency Tracking

Time Complexity:
get() -> O(1)
put() -> O(1)

Space Complexity: O(capacity)

Approach:
1. Maintain:
   - key -> node map
   - frequency -> doubly linked list map
2. Each node stores:
   - key
   - value
   - frequency
3. Increase frequency on every access.
4. Move node to corresponding frequency list.
5. Evict LFU node when capacity is reached.
6. If frequencies tie, remove the least recently used node.
*/

import java.util.HashMap;
import java.util.Map;

public class LFUCacheDesign {

    static class Node {

        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }

    static class LFUCache {

        private final int capacity;

        private int minFreq;

        private final Map<Integer, Node> keyMap;
        private final Map<Integer, DoublyLinkedList> freqMap;

        LFUCache(int capacity) {

            this.capacity = capacity;

            keyMap = new HashMap<>();
            freqMap = new HashMap<>();

            minFreq = 0;
        }

        public int get(int key) {

            if (!keyMap.containsKey(key)) {
                return -1;
            }

            Node node = keyMap.get(key);

            updateFrequency(node);

            return node.value;
        }

        public void put(int key, int value) {

            if (capacity == 0) {
                return;
            }

            if (keyMap.containsKey(key)) {

                Node node = keyMap.get(key);

                node.value = value;

                updateFrequency(node);

                return;
            }

            if (keyMap.size() == capacity) {

                DoublyLinkedList minList =
                        freqMap.get(minFreq);

                Node removed = minList.removeLast();

                keyMap.remove(removed.key);
            }

            Node node = new Node(key, value);

            keyMap.put(key, node);

            minFreq = 1;

            freqMap
                    .computeIfAbsent(1,
                            k -> new DoublyLinkedList())
                    .add(node);
        }

        private void updateFrequency(Node node) {

            int freq = node.freq;

            DoublyLinkedList currentList =
                    freqMap.get(freq);

            currentList.remove(node);

            if (freq == minFreq &&
                    currentList.size == 0) {

                minFreq++;
            }

            node.freq++;

            freqMap
                    .computeIfAbsent(node.freq,
                            k -> new DoublyLinkedList())
                    .add(node);
        }
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1));

        cache.put(3, 3);

        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}