
/*

Given a single positive integer x, we will write an expression of the form x (op1) x (op2) x (op3) x ... 
where each operator op1, op2, etc. is either addition, subtraction, multiplication, or division (+, -, *, or /).  
For example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.
When writing such an expression, we adhere to the following conventions:
The division operator (/) returns rational numbers.
There are no parentheses placed anywhere.
We use the usual order of operations: multiplication and division happens before addition and subtraction.
It's not allowed to use the unary negation operator (-).  
For example, "x - x" is a valid expression as it only uses subtraction, but "-x + x" is not because it uses negation.
We would like to write an expression with the least number of operators such that the expression equals the given target. 
Return the least number of operators used.

Example 1:
Input: x = 3, target = 19
Output: 5
Explanation: 3 * 3 + 3 * 3 + 3 / 3.  The expression contains 5 operations.

Example 2:
Input: x = 5, target = 501
Output: 8
Explanation: 5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5.  The expression contains 8 operations.

Example 3:
Input: x = 100, target = 100000000
Output: 3
Explanation: 100 * 100 * 100 * 100.  The expression contains 3 operations.

*/

/*

Solution: greedily multiple x to get close to target, then DFS for two cases (x*...*x)-(x*...*x) or (x*...*x) + (x*...*x)
O(2^n),O(n)

*/

public int leastOpsExpressTarget(int x, int target) {
    Map<Integer, Integer> memo = new HashMap<>();
    return dfs(memo, x, target);
}

private int dfs(Map<Integer, Integer> memo, int x, int target) {
    if (target == 1) {
        return x == 1 ? 0 : 1;
    }
    if (memo.containsKey(target)) {
        return memo.get(target);
    }
    int cnt = 0;
    long prod = x;
    while (prod < target) {
        cnt++;
        prod *= x;
    }
    int pos = Integer.MAX_VALUE, neg = Integer.MAX_VALUE;
    if (prod == target) {
        neg = cnt;
    } else if (prod - target < target) {
        neg = cnt + dfs(memo, x, (int)(prod - target)) + 1;
    }
    prod /= x;
    pos = dfs(memo, x, (int)(target - prod)) + (cnt == 0 ? 2 : cnt);
    int ans = Math.min(pos, neg);
    memo.put(target, ans);
    return ans;
}



