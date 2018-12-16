
/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

*/

/*

O(n^n),O(n)

*/

private int ans = 0;

public int totalNQueens(int n) {
    boolean[] cols = new boolean[n];
    boolean[] d1 = new boolean[2 * n - 1];
    boolean[] d2 = new boolean[2 * n - 1];
    dfs(0, cols, d1, d2, n);
    return ans;
}

private void dfs(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
    if (row == n) {
        ans++;
        return;
    }
    for (int col = 0; col < n; ++col) {
        if (cols[col] || d1[row + col] || d2[row - col + n - 1]) continue;
        cols[col] = true;
        d1[row + col] = true;
        d2[row - col + n - 1] = true;
        dfs(row + 1, cols, d1, d2, n);
        d2[row - col + n - 1] = false;
        d1[row + col] = false;
        cols[col] = false;
    }
}



