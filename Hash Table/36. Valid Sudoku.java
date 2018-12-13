
/*

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true

Example 2:
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. 
Since there are two 8's in the top left 3x3 sub-box, it is invalid.

*/

/*

Solution: for each cube, [3*(i/3)+j/3] means the cube's row index since it would +1 when i or j iterates 3 times 
                         [3*(i%3)+j%3] means the cube's col index since it would be 0,1,2 when i or j iterates 3 times
O(n^2),O(n^2)

*/

public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; ++i) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();
        Set<Character> cube = new HashSet<>();
        for (int j = 0; j < 9; ++j) {
            if (board[i][j] != '.' && !row.add(board[i][j])) return false;
            if (board[j][i] != '.' && !col.add(board[j][i])) return false;
            if (board[3*(i/3)+j/3][3*(i%3)+j%3] != '.' && !cube.add(board[3*(i/3)+j/3][3*(i%3)+j%3])) return false;
        }
    }
    return true;
}





