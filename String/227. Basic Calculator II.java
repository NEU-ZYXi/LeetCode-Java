
/*

Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:
Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

*/

/*

O(n),O(n)

*/

public int calculate(String s) {
    Deque<Integer> deque = new LinkedList<>();
    int ans = 0, tmp = 0;
    char sign = '+';
    for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) tmp = tmp * 10 + (c - '0');
        if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
            if (sign == '+') deque.offerLast(tmp);
            else if (sign == '-') deque.offerLast(-tmp);
            else if (sign == '*') deque.offerLast(tmp * deque.pollLast());
            else if (sign == '/') deque.offerLast(deque.pollLast() / tmp);
            sign = c;
            tmp = 0;
        }
    }
    while (!deque.isEmpty()) ans += deque.pollLast();
    return ans;
}




