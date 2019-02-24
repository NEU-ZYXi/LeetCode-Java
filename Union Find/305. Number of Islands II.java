
/*

A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:
Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
0 0 0
0 0 0
0 0 0

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
1 0 0
0 0 0   Number of islands = 1
0 0 0

Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
1 1 0
0 0 0   Number of islands = 1
0 0 0

Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
1 1 0
0 0 1   Number of islands = 2
0 0 0

Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
1 1 0
0 0 1   Number of islands = 3
0 1 0

*/

/*

Solution: use union find, for each position, check if it's neighbor is an island, and union them
O(plogp),O(nm), where p is the length of positions

*/

private int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> ans = new ArrayList<>();
    int[] id = new int[m * n];
    int[] rank = new int[m * n];
    Arrays.fill(id, -1);
    Arrays.fill(rank, 1);
    int cnt = 0;
    for (int[] pos : positions) {
        int x = pos[0], y = pos[1], i = x * n + y;
        id[i] = i;
        cnt++;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1], ni = nx * n + ny;
            if (0 <= nx && nx < m && 0 <= ny && ny < n && id[ni] != -1) {
                if (find(id, i) != find(id, ni)) {
                    union(id, rank, i, ni);
                    cnt--;
                }
            }
        }
        ans.add(cnt);
    }
    return ans;
}

private int find(int[] id, int i) {
    while (i != id[i]) {
        i = id[i];
        id[i] = id[id[i]];
    }
    return i;
}

private void union(int[] id, int[] rank, int p, int q) {
    int rootp = find(id, p), rootq = find(id, q);
    if (rootp == rootq) return;
    else if (rank[rootp] > rank[rootq]) {
        rank[rootp] += rank[rootq];
        id[rootq] = id[rootp];
    } else {
        rank[rootq] += rank[rootp];
        id[rootp] = id[rootq];
    }
}




