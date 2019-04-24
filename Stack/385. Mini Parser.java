
/*

Given a nested list of integers represented as a string, implement a parser to deserialize it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.
Note: You may assume that the string is well-formed:
String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].

Example 1:
Given s = "324",
You should return a NestedInteger object which contains a single integer 324.

Example 2:
Given s = "[123,[456,[789]]]",
Return a NestedInteger object containing a nested list with 2 elements:
1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.

*/

/*

O(n),O(n)

*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
        Deque<NestedInteger> deque = new LinkedList<>();
        NestedInteger ans = new NestedInteger();
        deque.offerLast(ans);
        for (int i = 1, j = 1; j < s.length(); ++j) {
            char c = s.charAt(j);
            if (c == '[') {
                NestedInteger tmp = new NestedInteger();
                deque.peekLast().add(tmp);
                deque.offerLast(tmp);
                i = j + 1;
            } else if (c == ',' || c == ']') {
                if (j > i) {
                    Integer num = Integer.valueOf(s.substring(i, j));
                    deque.peekLast().add(new NestedInteger(num));
                }
                i = j + 1;
                if (c == ']') deque.pollLast();
            }
        }
        return ans;
    }
}




