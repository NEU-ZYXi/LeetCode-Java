
/*

In a given grid, each cell can have one of three values:
the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

*/

/*

O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int orangesRotting(int[][] grid) {
    int n = grid.length, m = grid[0].length, ans = 0, cnt = 0;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (grid[i][j] == 2) {
                queue.offer(new int[] {i, j});
            } else if (grid[i][j] == 1) {
                cnt++;
            }
        }
    }
    while (!queue.isEmpty() && cnt > 0) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny});
                    cnt--;
                }
            }
        }
        ans++;
    }
    return cnt == 0 ? ans : -1;
}




