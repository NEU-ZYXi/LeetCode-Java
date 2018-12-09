
/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true

*/

/*

O(n),O(n)

*/

public boolean isValid(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '[') deque.offerLast(']');
        else if (c == '{') deque.offerLast('}');
        else if (c == '(') deque.offerLast(')');
        else if (deque.isEmpty() || c != deque.pollLast()) return false;
    }
    return deque.isEmpty();
}




