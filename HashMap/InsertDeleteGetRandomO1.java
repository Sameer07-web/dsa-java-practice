/*
Problem: Insert Delete GetRandom O(1)

Difficulty: Medium

Source: LeetCode 380

Description:
Implement the RandomizedSet class.

The class supports the following operations in O(1) average time:

- insert(val)
- remove(val)
- getRandom()

Example:

Input:

insert(1)
remove(2)
insert(2)
getRandom()
remove(1)
insert(2)
getRandom()

Output:

true
false
true
2
true
false
2

Pattern: HashMap + ArrayList

Time Complexity:
Insert     : O(1)
Remove     : O(1)
GetRandom  : O(1)

Space Complexity: O(n)

Approach:
1. Use a HashMap to store:
   Value -> Index in ArrayList.
2. Store all values inside an ArrayList.
3. For insertion:
   - If value exists, return false.
   - Append value to ArrayList.
   - Store its index in HashMap.
4. For deletion:
   - Swap the element with the last element.
   - Update the last element's index.
   - Remove the last element.
   - Remove the deleted value from HashMap.
5. Generate a random index to return a random element.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class InsertDeleteGetRandomO1 {

    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random;

    public InsertDeleteGetRandomO1() {

        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(list.size());

        return list.get(index);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InsertDeleteGetRandomO1 randomizedSet =
                new InsertDeleteGetRandomO1();

        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        System.out.println("Operations:");
        System.out.println("1 value        -> insert(value)");
        System.out.println("2 value        -> remove(value)");
        System.out.println("3              -> getRandom()");

        for (int i = 0; i < operations; i++) {

            int type = sc.nextInt();

            if (type == 1) {

                int value = sc.nextInt();

                System.out.println(
                        randomizedSet.insert(value));

            } else if (type == 2) {

                int value = sc.nextInt();

                System.out.println(
                        randomizedSet.remove(value));

            } else {

                if (randomizedSet.list.isEmpty()) {
                    System.out.println("Set is empty");
                } else {
                    System.out.println(
                            randomizedSet.getRandom());
                }
            }
        }

        sc.close();
    }
}