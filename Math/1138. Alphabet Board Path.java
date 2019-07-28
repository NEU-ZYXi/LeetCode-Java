
/*

On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
We may make the following moves:
'U' moves our position up one row, if the position exists on the board;
'D' moves our position down one row, if the position exists on the board;
'L' moves our position left one column, if the position exists on the board;
'R' moves our position right one column, if the position exists on the board;
'!' adds the character board[r][c] at our current position (r, c) to the answer.
(Here, the only positions that exist on the board are positions with letters on them.)
Return a sequence of moves that makes our answer equal to target in the minimum number of moves. 
You may return any path that does so.

Example 1:
Input: target = "leet"
Output: "DDR!UURRR!!DDD!"

Example 2:
Input: target = "code"
Output: "RR!DDRR!UUL!R!"

*/

/*

Solution: use index/5 and index%5 to find the row and col for current character
          for 'z', must go left before going down and go up before going right
O(n),O(1)          

*/

public String alphabetBoardPath(String target) {
    StringBuilder ans = new StringBuilder();
    int x = 0, y = 0, n = target.length();
    for (int i = 0; i < n; ++i) {
        int idx = target.charAt(i) - 'a', row = idx / 5, col = idx % 5;
        while (y > col) {
            ans.append('L');
            y--;
        }
        while (x > row) {
            ans.append('U');
            x--;
        }
        while (y < col) {
            ans.append('R');
            y++;
        }
        while (x < row) {
            ans.append('D');
            x++;
        }
        ans.append('!');
    }
    return ans.toString();
}



