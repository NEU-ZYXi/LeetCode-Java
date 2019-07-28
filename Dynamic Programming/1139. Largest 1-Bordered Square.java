
/*

Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, 
or 0 if such a subgrid doesn't exist in the grid.

Example 1:
Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 9

Example 2:
Input: grid = [[1,1,0,0]]
Output: 1

*/

/*

Solution: left[i][j] means the consecutive '1' from left of a[i][j], top[i][j] means the consecutive '1' from top of a[i][j]
          left[i][j]=left[i][j-1] and top[i][j]=top[i-1][j] if a[i][j]=1
          for each candidate length of square, check if four corners have at least length number of consecutive '1'
O(nm*min(n,m)),O(nm)          

*/

public int largest1BorderedSquare(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int[][] left = new int[n][m];
    int[][] top = new int[n][m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 1) {
                left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
            }
        }
    }
    for (int len = Math.min(n, m); len > 0; --len) {
        for (int i = 0; i < n - len + 1; ++i) {
            for (int j = 0; j < m - len + 1; ++j) {
                if (left[i][j + len - 1] >= len && left[i + len - 1][j + len - 1] >= len && 
                    top[i + len - 1][j] >= len && top[i + len - 1][j + len - 1] >= len) {
                    return len * len;
                }
            }
        }
    }
    return 0;
}




