
/*

On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. 
Each worker and bike is a 2D coordinate on this grid.
Our goal is to assign a bike to each worker. Among the available bikes and workers,
we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker.
(If there are multiple (worker, bike) pairs with the same shortest Manhattan distance,
we choose the pair with the smallest worker index;
if there are multiple ways to do that, we choose the pair with the smallest bike index).
We repeat this process until there are no available workers.
The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.

Example 1:
Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: [1,0]
Explanation: 
Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].

Example 2:
Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: [0,2,1]
Explanation: 
Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, 
thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].

*/

/*

O(nmlog(nm)),O(nm)

*/

public int[] assignBikes(int[][] workers, int[][] bikes) {
    int n = workers.length, m = bikes.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    Set<Integer> vis = new HashSet<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2];
        }
    });
    for (int i = 0; i < n; ++i) {
        int[] worker = workers[i];
        for (int j = 0; j < m; ++j) {
            int[] bike = bikes[j];
            int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
            pq.offer(new int[] {i, j, dist});
        }
    }
    while (vis.size() < n) {
        int[] cur = pq.poll();
        int worker = cur[0], bike = cur[1];
        if (ans[worker] == -1 && vis.add(bike)) {
            ans[worker] = bike;
        }
    }
    return ans;
}




