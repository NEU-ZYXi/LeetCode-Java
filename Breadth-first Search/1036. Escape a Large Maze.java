
/*

In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
We start at the source square and want to reach the target square. 
Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
Return true if and only if it is possible to reach the target square through a sequence of moves.

Example 1:
Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
Output: false
Explanation: 
The target square is inaccessible starting from the source square, because we can't walk outside the grid.

Example 2:
Input: blocked = [], source = [0,0], target = [999999,999999]
Output: true
Explanation: 
Because there are no blocked cells, it's possible to reach the target square.

*/

/*

Solution: check whether source or target is surrounded by all blocked cells
          for inifinite maze, if BFS steps are more than blocked cells, there is always a way
O(n),O(n) where n is the size of blocked cells          

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    if (blocked.length == 0) {
        return true;
    }
    Set<String> block = new HashSet<>();
    for (int[] b : blocked) {
        block.add(b[0] + "," + b[1]);
    }
    return bfs(block, new HashSet<>(), source, target) && bfs(block, new HashSet<>(), target, source);
}

private boolean bfs(Set<String> block, Set<String> vis, int[] s, int[] t) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(s);
    vis.add(s[0] + "," + s[1]);
    int cnt = block.size();
    while (!queue.isEmpty() && cnt-- > 0) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            if (x == t[0] && y == t[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                String nxt = nx + "," + ny;
                if (0 <= nx && nx < 1000000 && 0 <= ny && ny < 1000000 && !vis.contains(nxt) && !block.contains(nxt)) {
                    vis.add(nxt);
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
    return !queue.isEmpty();
}




