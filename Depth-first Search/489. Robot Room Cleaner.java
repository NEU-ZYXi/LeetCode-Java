
/*

Given a robot cleaner in a room modeled as a grid.
Each cell in the grid can be empty or blocked.
The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
Design an algorithm to clean the entire room using only the 4 given APIs shown below.

interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}

Example:
Input:
room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3
Explanation:
All grids in the room are marked by either 0 or 1.
0 means the cell is blocked, while 1 means the cell is accessible.
The robot initially starts at the position of row=1, col=3.
From the top left corner, its position is one row below and three columns right.

*/

/*

Solution: use a index to represent the current direction, initialize directions in order with turning left order
          DFS for each cell with each direction, update the next direction index
O(n),O(n) where n is the number of cells          

*/

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    
    private int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public void cleanRoom(Robot robot) {
        Set<String> vis = new HashSet<>();
        dfs(robot, vis, 0, 0, 0);
    }
    
    private void dfs(Robot robot, Set<String> vis, int x, int y, int dir) {
        vis.add(x + "," + y);
        robot.clean();
        for (int i = 0; i < 4; ++i) {
            int nx = x + dirs[(i + dir) % 4][0], ny = y + dirs[(i + dir) % 4][1];
            if (!vis.contains(nx + "," + ny) && robot.move()) {
                dfs(robot, vis, nx, ny, (i + dir) % 4);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnLeft();
        }
    }
}




