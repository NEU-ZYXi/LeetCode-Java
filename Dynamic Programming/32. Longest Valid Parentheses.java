
/*

Given a string containing just the characters '(' and ')', find the length of the longest valid parentheses substring.

Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

*/

/*

Solution 1.
dp[i] means the longest length of valid parentheses of s[0...i]
dp[i]=dp[i-2]+2 if s[i-1]='(' and s[i]=')'
dp[i]=dp[i-dp[i-1]-2]+dp[i-1]+2 if the case like '(())'
O(n),O(n)

*/

public int longestValidParentheses(String s) {
    int n = s.length(), ans = 0;
    int[] dp = new int[n];
    for (int i = 1; i < n; ++i) {
        if (s.charAt(i) == ')') {
            if (s.charAt(i - 1) == '(') 
                dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
            else if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(')
                dp[i] = i > dp[i - 1] + 1 ? dp[i - dp[i - 1] - 2] + dp[i - 1] + 2 : dp[i - 1] + 2;
        }
        ans = Math.max(ans, dp[i]);
    }
    return ans;
}


/*

Solution 2.
use a deque to track the index of each position that can not form a valid parentheses, 
the length between two adjacent index is a valid parentheses
O(n),O(n)

*/

public int longestValidParentheses(String s) {
    int ans = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < s.length(); ++i) {
        if (s.charAt(i) == '(') deque.offerLast(i);
        else { 
            if (deque.isEmpty()) deque.offerLast(i);
            else if (s.charAt(deque.peekLast()) == '(') deque.pollLast();
            else deque.offerLast(i);
        }
    }
    if (deque.isEmpty()) ans = s.length();
    else {
        int l = 0, r = s.length();
        while (!deque.isEmpty()) {
            l = deque.pollLast();
            ans = Math.max(ans, r - l - 1);
            r = l;
        }
        ans = Math.max(ans, r);
    }
    return ans;
}
    
    
    


