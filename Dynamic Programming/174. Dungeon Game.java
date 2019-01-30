
/*

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. 
The dungeon consists of M x N rooms laid out in a 2D grid. 
Nnight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. 
If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 
if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

*/

/*

Solution: start from bottom right to top left to do the DP
          dp[i][j] means the minimum life when we start from dungeon[i][j] to reach the bottom right
          1. downside: max(1,dp[i+1][j]-dungeon[i][j]), which is to reach dungeon[i+1][j], at least dp[i+1][j]-dungeon[i][j] 
          2. rightside: max(1,dp[i][j+1]-dungeon[i][j]), which is to reach dungeon[i][j+1], at least dp[i][j+1]-dungeon[i][j]
          3. dp[i][j]=min(downside,rightside)
O(nm),O(nm)          
          
*/

public int calculateMinimumHP(int[][] dungeon) {
    int n = dungeon.length, m = dungeon[0].length;
    int[][] dp = new int[n][m];
    dp[n - 1][m - 1] = Math.max(1, 1 - dungeon[n - 1][m - 1]);
    for (int i = n - 2; i >= 0; i--) dp[i][m - 1] = Math.max(1, dp[i + 1][m - 1] - dungeon[i][m - 1]);
    for (int j = m - 2; j >= 0; j--) dp[n - 1][j] = Math.max(1, dp[n - 1][j + 1] - dungeon[n - 1][j]);
    for (int i = n - 2; i >= 0; i--) {
        for (int j = m - 2; j >= 0; j--) {
            int left = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
            int top = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
            dp[i][j] = Math.min(left, top);
        }
    }
    return dp[0][0];
}




