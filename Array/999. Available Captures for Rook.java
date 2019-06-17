
/*

On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  
These are given as characters 'R', '.', 'B', and 'p' respectively. 
Uppercase characters represent white pieces, and lowercase characters represent black pieces.
The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), 
then moves in that direction until it chooses to stop, reaches the edge of the board, 
or captures an opposite colored pawn by moving to the same square it occupies.  
Also, rooks cannot move into the same square as other friendly bishops.
Return the number of pawns the rook can capture in one move.

Example 1:
Input: 
[[".",".",".",".",".",".",".","."],
 [".",".",".","p",".",".",".","."],
 [".",".",".","R",".",".",".","p"],
 [".",".",".",".",".",".",".","."],
 [".",".",".",".",".",".",".","."],
 [".",".",".","p",".",".",".","."],
 [".",".",".",".",".",".",".","."],
 [".",".",".",".",".",".",".","."]]
Output: 3
Explanation: 
In this example the rook is able to capture all the pawns.

Example 2:
Input: 
[[".",".",".",".",".",".",".","."],
 [".","p","p","p","p","p",".","."],
 [".","p","p","B","p","p",".","."],
 [".","p","B","R","B","p",".","."],
 [".","p","p","B","p","p",".","."],
 [".","p","p","p","p","p",".","."],
 [".",".",".",".",".",".",".","."],
 [".",".",".",".",".",".",".","."]]
Output: 0
Explanation: 
Bishops are blocking the rook to capture any pawn.

Example 3:
Input: 
[[".",".",".",".",".",".",".","."],
 [".",".",".","p",".",".",".","."],
 [".",".",".","p",".",".",".","."],
 ["p","p",".","R",".","p","B","."],
 [".",".",".",".",".",".",".","."],
 [".",".",".","B",".",".",".","."],
 [".",".",".","p",".",".",".","."],
 [".",".",".",".",".",".",".","."]]
Output: 3
Explanation: 
The rook can capture the pawns at positions b5, d6 and f5.

*/

/*

O(nm),O(1)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int numRookCaptures(char[][] board) {
    int n = board.length, m = board[0].length, ans = 0, x = 0, y = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (board[i][j] == 'R') {
                x = i;
                y = j;
                break;
            }
        }
    }
    for (int[] dir : dirs) {
        for (int i = x + dir[0], j = y + dir[1]; 0 <= i && i < n && 0 <= j && j < m; i += dir[0], j += dir[1]) {
            if (board[i][j] == 'p') {
                ans++;
            }
            if (board[i][j] != '.') {
                break;
            }
        } 
    }
    return ans;
}



