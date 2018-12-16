
/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

*/

/*

O(n^n),O(n)

*/

public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    boolean[] cols = new boolean[n];
    boolean[] d1 = new boolean[2 * n - 1];
    boolean[] d2 = new boolean[2 * n - 1];
    dfs(ans, new ArrayList<>(), 0, cols, d1, d2, n);
    return ans;
}

private void dfs(List<List<String>> ans, List<String> tmp, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
    if (row == n) {
        ans.add(new ArrayList<>(tmp));
        return;
    }
    for (int col = 0; col < n; ++col) {
        if (cols[col] || d1[row + col] || d2[row - col + n - 1]) continue;
        char[] board = new char[n];
        Arrays.fill(board, '.');
        board[col] = 'Q';
        tmp.add(new String(board));
        cols[col] = true;
        d1[row + col] = true;
        d2[row - col + n - 1] = true;
        dfs(ans, tmp, row + 1, cols, d1, d2, n);
        d2[row - col + n - 1] = false;
        d1[row + col] = false;
        cols[col] = false;
        tmp.remove(tmp.size() - 1);
        board[col] = '.';
    }
}




