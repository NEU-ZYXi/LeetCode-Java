
/*

There is a ball in a maze with empty spaces and walls. 
The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), 
but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. 
There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.
Given the ball position, the hole position and the maze, 
find out how the ball could drop into the hole by moving the shortest distance. 
The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). 
Output the moving directions by using 'u', 'd', 'l' and 'r'. 
Since there could be several different shortest ways, you should output the lexicographically smallest way. 
If the ball cannot reach the hole, output "impossible".
The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
You may assume that the borders of the maze are all walls. 
The ball and the hole coordinates are represented by row and column indexes. 

Example 1:
Input 1: a maze represented by a 2D array
0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0
Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)
Output: "lul"
Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2:
Input 1: a maze represented by a 2D array
0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0
Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)
Output: "impossible"
Explanation: The ball cannot reach the hole.

*/

/*

O(nmlog(n+m)),O(nm)

*/

class Point implements Comparable<Point> {
    private int x, y, dist;
    private String path;

    public Point(int x, int y, int dist, String path) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.path = path;
    }

    public int compareTo(Point point) {
        return this.dist == point.dist ? this.path.compareTo(point.path) : this.dist - point.dist;
    }
}

private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
private String[] dirChars = new String[] {"u", "d", "l", "r"};

public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    int n = maze.length, m = maze[0].length;
    Point[][] points = new Point[n][m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            points[i][j] = new Point(i, j, Integer.MAX_VALUE, "");
        }
    }
    PriorityQueue<Point> pq = new PriorityQueue<>();
    pq.offer(new Point(ball[0], ball[1], 0, ""));
    while (!pq.isEmpty()) {
        Point cur = pq.poll();
        if (points[cur.x][cur.y].compareTo(cur) <= 0) {
            continue;
        }
        points[cur.x][cur.y] = cur;
        for (int i = 0; i < 4; ++i) {
            int nx = cur.x + dirs[i][0], ny = cur.y + dirs[i][1], nd = cur.dist + 1;
            while (0 <= nx && nx < n && 0 <= ny && ny < m && maze[nx][ny] == 0 && (nx != hole[0] || ny != hole[1])) {
                nx += dirs[i][0];
                ny += dirs[i][1];
                nd++;
            }
            if (nx != hole[0] || ny != hole[1]) {
                nx -= dirs[i][0];
                ny -= dirs[i][1];
                nd--;
            }
            pq.offer(new Point(nx, ny, nd, cur.path + dirChars[i]));
        }
    }
    return points[hole[0]][hole[1]].dist == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].path;
}





