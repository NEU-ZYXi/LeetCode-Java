
/*

Given a positive integer N, return the number of positive integers less than or equal to N that have at least 1 repeated digit.

Example 1:
Input: 20
Output: 1
Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.

Example 2:
Input: 100
Output: 10
Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.

Example 3:
Input: 1000
Output: 262

*/

/*

Solution 1: use backtrack to construct numbers with only unique digits
O(10^n),O(n) where n is number of digits

*/

private int unique = 0;
    
public int numDupDigitsAtMostN(int N) {
    dfs(N, 0, new boolean[10]);
    return N - unique + 1;
}

private void dfs(int N, long cur, boolean[] vis) {
    if (cur > N) {
        return;
    } else {
        unique++;
    }
    for (int i = 0; i < 10; ++i) {
        if (i == 0 && cur == 0) {
            continue;
        }
        if (vis[i]) {
            continue;
        }
        vis[i] = true;
        dfs(N, cur * 10 + i, vis);
        vis[i] = false;
    }
}


/*

Solution 2: 

*/





