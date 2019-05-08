
/*

Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. 
You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F 
(T and F represent True and False respectively).

Note:
The length of the given string is ≤ 10000.
Each number will contain only one digit.
The conditional expressions group right-to-left (as usual in most languages).
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.

Example 1:
Input: "T?2:3"
Output: "2"
Explanation: If true, then result is 2; otherwise result is 3.

Example 2:
Input: "F?1:T?4:5"
Output: "4"
Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"
          
Example 3:
Input: "T?T?F:5:3"
Output: "F"
Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"

*/

/*

Solution 1: use a deque to store characters, whenever we have a '?', calculate the expression
O(n),O(n)

*/

public String parseTernary(String expression) {
    int n = expression.length();
    if (n == 0) return "";
    Deque<Character> deque = new LinkedList<>();
    for (int i = n - 1; i >= 0; --i) {
        char c = expression.charAt(i);
        if (!deque.isEmpty() && deque.peekLast() == '?') {
            deque.pollLast();
            char first = deque.pollLast();
            deque.pollLast();
            char second = deque.pollLast();
            if (c == 'T') deque.offerLast(first);
            else deque.offerLast(second);
        } else deque.offerLast(c);
    }
    return String.valueOf(deque.peekLast());
}


/*

Solution 2: find the matched '?' and ':', DFS for either the true condition or false condition
O(n^2),O(n)

*/

public String parseTernary(String expression) {
    int n = expression.length();
    return dfs(expression, 0, n - 1) + "";
}

private char dfs(String expression, int start, int end) {
    if (start == end) return expression.charAt(start);
    int i = start, cnt = 0;
    while (i <= end) {
        if (expression.charAt(i) == '?') cnt++;
        else if (expression.charAt(i) == ':') {
            cnt--;
            if (cnt == 0) break;
        }
        i++;
    }
    return expression.charAt(start) == 'T' ? dfs(expression, start + 2, i - 1) : dfs(expression, i + 1, end);
}



