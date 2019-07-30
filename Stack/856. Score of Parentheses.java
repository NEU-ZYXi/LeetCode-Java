
/*

Given a balanced parentheses string S, compute the score of the string based on the following rule:
() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 
Example 1:
Input: "()"
Output: 1

Example 2:
Input: "(())"
Output: 2

Example 3:
Input: "()()"
Output: 2

Example 4:
Input: "(()(()))"
Output: 6

*/

/*

O(n),O(n)

*/

public int scoreOfParentheses(String S) {
    int ans = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (char c : S.toCharArray()) {
        if (c == '(') {
            deque.offerLast(ans);
            ans = 0;
        } else {
            ans = deque.pollLast() + Math.max(2 * ans, 1);
        }
    }
    return ans;
}




