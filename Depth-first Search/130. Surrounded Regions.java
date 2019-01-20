
/*

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/

/*

O(mn),O(mn)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public void solve(char[][] board) {
    if (board.length == 0) return;
    int n = board.length, m = board[0].length;
    for (int i = 0; i < n; ++i) {
        if (board[i][0] == 'O') dfs(board, i, 0);
        if (board[i][m - 1] == 'O') dfs(board, i, m - 1);
    }
    for (int j = 0; j < m; ++j) {
        if (board[0][j] == 'O') dfs(board, 0, j);
        if (board[n - 1][j] == 'O') dfs(board, n - 1, j);
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (board[i][j] == 'O') board[i][j] = 'X';
            if (board[i][j] == '#') board[i][j] = 'O';
        }
    }
}

private void dfs(char[][] board, int x, int y) {
    int n = board.length, m = board[0].length;
    board[x][y] = '#';
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] != 'O') continue;
        dfs(board, nx, ny);
    }
}



