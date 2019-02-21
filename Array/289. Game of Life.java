
/*

According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. 
The next state is created by applying the above rules simultaneously to every cell in the current state, 
where births and deaths occur simultaneously.

Example:
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

*/

/*

O(nm),O(1)

*/

public void gameOfLife(int[][] board) {
    int n = board.length, m = board[0].length;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int cnt = 0;
            for (int r = Math.max(0, i - 1); r < Math.min(n, i + 2); ++r) {
                for (int c = Math.max(0, j - 1); c < Math.min(m, j + 2); ++c) {
                    cnt += board[r][c] > 1 ? board[r][c] - 2 : board[r][c];
                }
            }
            if (cnt == 3 && board[i][j] == 0) board[i][j] += 2;
            else if (cnt == 3 || cnt == 4 && board[i][j] == 1) board[i][j] += 2;
        }
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) board[i][j] = board[i][j] > 1 ? 1 : 0;
    }
}




