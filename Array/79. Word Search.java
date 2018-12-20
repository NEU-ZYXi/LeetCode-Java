
/*

en a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell. 
The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

*/

/*

O(nml),O(1), where l is the length of word

*/

private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
public boolean exist(char[][] board, String word) {
    if (board.length == 0) return false;
    int n = board.length, m = board[0].length;    
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (board[i][j] == word.charAt(0)) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
    }
    return false;
}

private boolean dfs(char[][] board, String word, int idx, int x, int y) {
    int n = board.length, m = board[0].length;
    if (idx == word.length()) return true;
    if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] != word.charAt(idx)) return false;
    char tmp = board[x][y];
    board[x][y] = '.';
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (dfs(board, word, idx + 1, nx, ny)) return true;
    }
    board[x][y] = tmp;
    return false;
}




