/*
Problem: LRU Cache

Difficulty: Medium

Source: LeetCode 146

Description:
Design a data structure that follows the constraints of
a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- LRUCache(int capacity)
- int get(int key)
- void put(int key, int value)

The functions get and put must each run in O(1) average time complexity.

Example:

Input:

LRUCache cache = new LRUCache(2);

put(1,1)
put(2,2)
get(1)
put(3,3)
get(2)
put(4,4)
get(1)
get(3)
get(4)

Output:

1
-1
-1
3
4

Pattern: HashMap + Doubly Linked List

Time Complexity:
get() : O(1)
put() : O(1)

Space Complexity: O(capacity)

Approach:
1. Store key-node mapping using a HashMap.
2. Maintain cache order using a Doubly Linked List.
3. Most recently used node stays near the head.
4. Least recently used node stays near the tail.
5. On get():
   - Move the node to the front.
6. On put():
   - Insert or update the node.
   - Remove the least recently used node if capacity exceeds.
*/

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {

    class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final HashMap<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

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
        }

        Node node = new Node(key, value);

        map.put(key, node);

        insert(node);

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        System.out.println("Operations:");
        System.out.println("1 key           -> get(key)");
        System.out.println("2 key value     -> put(key, value)");

        for (int i = 0; i < operations; i++) {

            int type = sc.nextInt();

            if (type == 1) {

                int key = sc.nextInt();

                System.out.println(cache.get(key));

            } else {

                int key = sc.nextInt();
                int value = sc.nextInt();

                cache.put(key, value);
            }
        }

        sc.close();
    }
}