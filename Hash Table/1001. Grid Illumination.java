
/*

On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.
Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is on.  
Each lamp that is on illuminates every square on its x-axis, y-axis, and both diagonals (similar to a Queen in chess).
For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is illuminated, else 0.
After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell (x, y) 
or are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)
Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query queries[i].

Example 1:
Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
Explanation: 
Before performing the first query we have both lamps [0,0] and [4,4] on.
The grid representing which cells are lit looks like this, where [0,0] is the top left corner, 
and [4,4] is the bottom right corner:
1 1 1 1 1
1 1 0 0 1
1 0 1 0 1
1 0 0 1 1
1 1 1 1 1
Then the query at [1, 1] returns 1 because the cell is lit.  
After this query, the lamp at [0, 0] turns off, and the grid now looks like this:
1 0 0 0 1
0 1 0 0 1
0 0 1 0 1
0 0 0 1 1
1 1 1 1 1
Before performing the second query we have only the lamp [4,4] on.  
Now the query at [1,0] returns 0, because the cell is no longer lit.

*/

/*

Solution: use four maps for four directions (x, y, x+y, x-y)
          for each query, check if any direction is on, then turn off 9 adjacent grids
O(n),O(n)          

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {0, 0}, {1, 0}, {1, -1}, {1, 1}, {-1, 0}, {-1, 1}, {-1, -1}};
    
public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    int n = queries.length;
    int[] ans = new int[n];
    Map<Integer, Integer> row = new HashMap<>();
    Map<Integer, Integer> col = new HashMap<>();
    Map<Integer, Integer> d1 = new HashMap<>();
    Map<Integer, Integer> d2 = new HashMap<>();
    Map<Integer, Boolean> map = new HashMap<>();
    for (int[] lamp : lamps) {
        int x = lamp[0], y = lamp[1];
        row.put(x, row.getOrDefault(x, 0) + 1);
        col.put(y, col.getOrDefault(y, 0) + 1);
        d1.put(x + y, d1.getOrDefault(x + y, 0) + 1);
        d2.put(x - y, d2.getOrDefault(x - y, 0) + 1);
        map.put(N * x + y, true);
    }
    for (int i = 0; i < n; ++i) {
        int x = queries[i][0], y = queries[i][1];
        ans[i] = (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || 
                  d1.getOrDefault(x + y, 0) > 0 || d2.getOrDefault(x - y, 0) > 0) ? 1 : 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (map.getOrDefault(N * nx + ny, false)) {
                row.put(nx, row.getOrDefault(nx, 1) - 1);
                col.put(ny, col.getOrDefault(ny, 1) - 1);
                d1.put(nx + ny, d1.getOrDefault(nx + ny, 1) - 1);
                d2.put(nx - ny, d2.getOrDefault(nx - ny, 1) - 1);
                map.put(N * nx + ny, false);
            }
        }
    }
    return ans;
}




