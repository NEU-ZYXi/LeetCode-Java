
/*

Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99

*/

/*

Solution 1: O(9^n),O(n)

*/

public int countNumbersWithUniqueDigits(int n) {
    boolean[] vis = new boolean[10];
    return dfs(n, vis, 0);
}

private int dfs(int n, boolean[] vis, int idx) {
    if (idx == n) return 1;
    int ans = 1;
    for (int i = (idx == 0 ? 1 : 0); i <= 9; ++i) {
        if (!vis[i]) {
            vis[i] = true;
            ans += dfs(n, vis, idx + 1);
            vis[i] = false;
        }
    }
    return ans;
}


/*

Solution 2: 9 options for 1st position, 9 options for 2nd position, 8 options for 3rd position,... where n<=10
O(1),O(1)

*/

public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    int ans = 10, cur = 9, num = 9;
    while (n > 1 && num > 0) {
        cur *= num;
        ans += cur;
        num--;
        n--;
    }
    return ans;
}




