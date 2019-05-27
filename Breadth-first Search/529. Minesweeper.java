
/*

Let's play the minesweeper game (Wikipedia, online game)!
You are given a 2D char matrix representing the game board. 
'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 
'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, 
digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), 
return the board after revealing this position according to the following rules:
If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, 
then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, 
then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
 
Example 1:
Input: 
[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]
Click : [3,0]
Output: 
[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Example 2:
Input: 
[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
Click : [1,2]
Output: 
[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

*/

/*

O(nm),O(1)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
    
public char[][] updateBoard(char[][] board, int[] click) {
    int x = click[0], y = click[1];
    if (board[x][y] == 'M') {
        board[x][y] = 'X';
        return board;
    }
    dfs(board, x, y);
    return board;
}

private void dfs(char[][] board, int x, int y) {
    int n = board.length, m = board[0].length;
    int cnt = count(board, x, y);
    if (cnt == 0) {
        board[x][y] = 'B';
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 'E') {
                dfs(board, nx, ny);
            }
        }
    } else {
        board[x][y] = (char)(cnt + '0');
    }
}

private int count(char[][] board, int x, int y) {
    int ans = 0, n = board.length, m = board[0].length;
    for (int[] dir : dirs) {
        int nx = x + dir[0], ny = y + dir[1];
        if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 'M') {
            ans++;
        }
    }
    return ans;
}




