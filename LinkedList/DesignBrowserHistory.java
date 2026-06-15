/*
Problem: Design Browser History

Difficulty: Medium

Source: LeetCode 1472

Description:
You have a browser with one tab where you start on the homepage.

Implement the BrowserHistory class:

1. BrowserHistory(String homepage)
2. visit(String url)
3. back(int steps)
4. forward(int steps)

Example:
Input:
BrowserHistory("leetcode.com")
visit("google.com")
visit("facebook.com")
visit("youtube.com")

back(1)
back(1)
forward(1)

visit("linkedin.com")

forward(2)
back(2)
back(7)

Output:
facebook.com
google.com
facebook.com
linkedin.com
google.com
leetcode.com

Pattern: Doubly Linked List

Time Complexity:
visit()   -> O(1)
back()    -> O(steps)
forward() -> O(steps)

Space Complexity: O(n)

Approach:
1. Store each webpage as a node in a doubly linked list.
2. Use prev pointer for backward navigation.
3. Use next pointer for forward navigation.
4. When visiting a new page:
   - Clear forward history.
   - Attach the new page.
5. Move left for back().
6. Move right for forward().
*/

public class DesignBrowserHistory {

    static class Node {

        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    static class BrowserHistory {

        private Node current;

        public BrowserHistory(String homepage) {
            current = new Node(homepage);
        }

        public void visit(String url) {

            Node newNode = new Node(url);

            current.next = newNode;
            newNode.prev = current;

            current = newNode;
        }

        public String back(int steps) {

            while (steps > 0 && current.prev != null) {
                current = current.prev;
                steps--;
            }

            return current.url;
        }

        public String forward(int steps) {

            while (steps > 0 && current.next != null) {
                current = current.next;
                steps--;
            }

            return current.url;
        }
    }

    public static void main(String[] args) {

        BrowserHistory browser =
                new BrowserHistory("leetcode.com");

        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");

        System.out.println(browser.back(1));
        System.out.println(browser.back(1));
        System.out.println(browser.forward(1));

        browser.visit("linkedin.com");

        System.out.println(browser.forward(2));
        System.out.println(browser.back(2));
        System.out.println(browser.back(7));
    }
}