/*
Problem: LRU Cache

Difficulty: Medium

Source: LeetCode 146

Description:
Design a data structure that follows the constraints of a
Least Recently Used (LRU) Cache.

Implement the LRUCache class:

1. LRUCache(int capacity)
2. int get(int key)
3. void put(int key, int value)

The functions get and put must each run in O(1) average time complexity.

Example:
Input:
LRUCache cache = new LRUCache(2);

cache.put(1, 1);
cache.put(2, 2);

cache.get(1);

cache.put(3, 3);

cache.get(2);

cache.put(4, 4);

cache.get(1);
cache.get(3);
cache.get(4);

Output:
1
-1
-1
3
4

Pattern: HashMap + Doubly Linked List

Time Complexity:
get() -> O(1)
put() -> O(1)

Space Complexity: O(capacity)

Approach:
1. Use HashMap for O(1) lookup.
2. Use Doubly Linked List to maintain usage order.
3. Most recently used node stays near head.
4. Least recently used node stays near tail.
5. Move accessed nodes to the front.
6. Remove LRU node when capacity is exceeded.
*/

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDesign {

    static class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        private final int capacity;

        private final Map<Integer, Node> map;

        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {

            this.capacity = capacity;
            this.map = new HashMap<>();

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {

            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            remove(node);
            insert(node);

            return node.value;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {

                remove(map.get(key));
                map.remove(key);
            }

            Node node = new Node(key, value);

            insert(node);
            map.put(key, node);

            if (map.size() > capacity) {

                Node lru = tail.prev;

                remove(lru);
                map.remove(lru.key);
            }
        }

        private void insert(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        private void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1));

        cache.put(3, 3);

        System.out.println(cache.get(2));

        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}