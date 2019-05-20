
/*

There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. 
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
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:
Input 1: a maze represented by a 2D array
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0
Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)
Output: false
Explanation: There is no way for the ball to stop at the destination.

*/

/*

O(nm),O(nm)

*/

private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int n = maze.length, m = maze[0].length;
    boolean[][] vis = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(start);
    vis[start[0]][start[1]] = true;
    while (!queue.isEmpty()) {
        int sz = queue.size();
        for (int i = 0; i < sz; ++i) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                while (0 <= nx && nx < n && 0 <= ny && ny < m && maze[nx][ny] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                }
                nx -= dir[0];
                ny -= dir[1];
                if (nx == destination[0] && ny == destination[1]) {
                    return true;
                }
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
    return false;
}





