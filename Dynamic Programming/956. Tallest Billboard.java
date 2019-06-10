
/*

You are installing a billboard and want it to have the largest height.  
The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.
You have a collection of rods which can be welded together.  
For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0.

Example 1:
Input: [1,2,3,6]
Output: 6
Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.

Example 2:
Input: [1,2,3,4,5,6]
Output: 10
Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.

Example 3:
Input: [1,2]
Output: 0
Explanation: The billboard cannot be supported, so we return 0.

*/

/*

Solution: knapsack problem, use '+' and '-' to separate into two groups, which means the value we could get is [-sum...sum]
          dp[i][j] means whether we could use rods[1...i] to get j sum, final state is dp[n][sum]
          max[i][j] tracks the maximum sum of all positive numbers
          1. dp[i][j]=dp[i-1][j] which means do not choose the rods[i-1]
          2. dp[i][j]=dp[i-1][j-rods[i-1]] which means choose the rods[i-1] and mark it as '+'
          3. dp[i][j]=dp[i-1][j+rods[i-1]] which means choose the rods[i-1] and mark it as '-'
O(nm),O(nm) where n is length of rods and m is sum of all rods          

*/

public int tallestBillboard(int[] rods) {
    int n = rods.length, sum = 0;
    for (int rod : rods) {
        sum += rod;
    }
    sum *= 2;
    boolean[][] dp = new boolean[n + 1][sum + 1];
    int[][] max = new int[n + 1][sum + 1];
    dp[0][sum / 2] = true;
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= sum; ++j) {
            if (dp[i - 1][j]) {
                dp[i][j] = true;
                max[i][j] = Math.max(max[i][j], max[i - 1][j]); 
            }
            if (j >= rods[i - 1] && dp[i - 1][j - rods[i - 1]]) {
                dp[i][j] = true;
                max[i][j] = Math.max(max[i][j], max[i - 1][j - rods[i - 1]] + rods[i - 1]);
            }
            if (j + rods[i - 1] <= sum && dp[i - 1][j + rods[i - 1]]) {
                dp[i][j] = true;
                max[i][j] = Math.max(max[i][j], max[i - 1][j + rods[i - 1]]);
            }
        }
    }
    return max[n][sum / 2];
}




