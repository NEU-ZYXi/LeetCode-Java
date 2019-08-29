
/*

You are asked to cut off trees in a forest for a golf event. 
The forest is represented as a non-negative 2D map, in this map:
0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through,
and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height,
always cut off the tree with lowest height first. 
And after cutting, the original place has the tree will become a grass (value 1).
You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. 
If you can't cut off all the trees, output -1 in that situation.
You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
 
Example 2:
Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
 
Example 3:
Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

*/

/*

O(nmlog(nm)),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int cutOffTree(List<List<Integer>> forest) {
    int ans = 0, n = forest.size(), m = forest.get(0).size();
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    });
    int[] cur = new int[] {0, 0, 1};
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            if (forest.get(i).get(j) > 1) {
                pq.offer(new int[] {i, j, forest.get(i).get(j)});
            }
        }
    }
    while (!pq.isEmpty()) {
        int[] next = pq.poll();
        int cnt = bfs(forest, cur, next);
        if (cnt == -1) {
            return -1;
        }
        ans += cnt;
        cur = next;
    }
    return ans;
}

private int bfs(List<List<Integer>> forest, int[] cur, int[] next) {
    int ans = 0, n = forest.size(), m = forest.get(0).size();
    boolean[][] vis = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(cur);
    vis[cur[0]][cur[1]] = true;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            if (x == next[0] && y == next[1]) {
                return ans;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && forest.get(nx).get(ny) != 0 && !vis[nx][ny]) {
                    queue.offer(new int[] {nx, ny, forest.get(nx).get(ny)});
                    vis[nx][ny] = true;
                }
            }
        }
        ans++;
    }
    return -1;
}




