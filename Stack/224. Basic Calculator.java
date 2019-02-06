
/*

Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces .

Example 1:
Input: "1 + 1"
Output: 2

Example 2:
Input: " 2-1 + 2 "
Output: 3

Example 3:
Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

*/

/*

O(n),O(n)

*/

public int calculate(String s) {
    Deque<Integer> deque = new LinkedList<>();
    int ans = 0, tmp = 0, sign = 1;
    for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) tmp = tmp * 10 + (c - '0');
        else if (c == '+') {
            ans += sign * tmp;
            sign = 1;
            tmp = 0;
        } else if (c == '-') {
            ans += sign * tmp;
            sign = -1;
            tmp = 0;
        } else if (c == '(') {
            deque.offerLast(ans);
            deque.offerLast(sign);
            ans = 0;
            sign = 1;
        } else if (c == ')') {
            ans += sign * tmp;
            ans *= deque.pollLast();
            ans += deque.pollLast();
            tmp = 0;
        }
    }
    if (tmp != 0) ans += sign * tmp;
    return ans;
}



