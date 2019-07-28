
/*

Given a grid where each entry is only 0 or 1, find the number of corner rectangles.
A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle.
Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

Example 1:
Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 
Example 2:
Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 
Example 3:
Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.

*/

/*

Solution: dp[i][j] means the number of rows which have i and j column as '1'
          for each element a[i][j], then for each next column k, it can build dp[j][k] more rectangles
O(nm^2),O(m^2)          

*/

public int countCornerRectangles(int[][] grid) {
    int n = grid.length, m = grid[0].length, ans = 0;
    int[][] dp = new int[m][m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                for (int k = j + 1; k < m; ++k) {
                    if (grid[i][k] == 1) {
                        ans += dp[j][k];
                        dp[j][k]++;
                    }
                }
            }
        }
    }
    return ans;
}



