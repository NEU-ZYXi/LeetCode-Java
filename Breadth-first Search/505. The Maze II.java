
/*

There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. 
The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). 
If the ball cannot stop at the destination, return -1.
The maze is represented by a binary 2D array. 
1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. 
The start and destination coordinates are represented by row and column indexes.

Example 1:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)
Output: 12
Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
             The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

Example 2:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)
Output: -1
Explanation: There is no way for the ball to stop at the destination.

*/

/*

O(nmlog(max(n,m))),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    int n = maze.length, m = maze[0].length;
    int[][] dist = new int[n][m];
    for (int[] d : dist) {
        Arrays.fill(d, Integer.MAX_VALUE);
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[2] - b[2];
        }
    });
    pq.offer(new int[] {start[0], start[1], 0});
    while (!pq.isEmpty()) {
        int[] cur = pq.poll();
        int x = cur[0], y = cur[1], d = cur[2];
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1], nd = d + 1;
            while (0 <= nx && nx < n && 0 <= ny && ny < m && maze[nx][ny] == 0) {
                nx += dir[0];
                ny += dir[1];
                nd++;
            }
            nx -= dir[0];
            ny -= dir[1];
            nd--;
            if (dist[nx][ny] > nd) {
                dist[nx][ny] = nd;
                pq.offer(new int[] {nx, ny, nd});
            }
        }
    }
    return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
}




