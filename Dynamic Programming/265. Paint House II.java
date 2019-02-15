
/*

There are a row of n houses, each house can be painted with one of the k colors. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.

Example:
Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 

*/

/*

Solution 1: dp[i][j] means the minimum cost to paint ith house with jth color
            dp[i][j]=min(dp[i-1][k]) for each k where j!=k
            find minimum of dp[n-1][i]
O(nm^2),O(nm)          

*/

public int minCostII(int[][] costs) {
    if (costs.length == 0) return 0;
    int ans = Integer.MAX_VALUE, n = costs.length, m = costs[0].length;
    int[][] dp = new int[n][m];
    for (int i = 0; i < m; ++i) dp[0][i] = costs[0][i];
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < m; ++k) {
                if (j == k) continue;
                min = Math.min(min, dp[i - 1][k]);
            }
            dp[i][j] = min + costs[i][j];
        }
    }
    for (int i = 0; i < m; ++i) ans = Math.min(ans, dp[n - 1][i]);
    return ans;
}


/*

Solution 2: since we only need to maintain the min1 and min2 of dp[i-1][j], in case the min1 is the same color
O(nm),O(1)

*/

public int minCostII(int[][] costs) {
    if (costs.length == 0) return 0;
    int n = costs.length, m = costs[0].length;
    int min1 = 0, min2 = 0, prev = -1;
    for (int i = 0; i < n; ++i) {
        int tmp1 = Integer.MAX_VALUE, tmp2 = Integer.MAX_VALUE, cur = -1;
        for (int j = 0; j < m; ++j) {
            int cost = costs[i][j] + (prev == j ? min2 : min1);
            if (cost < tmp1) {
                tmp2 = tmp1;
                tmp1 = cost;
                cur = j;
            } else if (cost < tmp2) tmp2 = cost;
        }
        min1 = tmp1;
        min2 = tmp2;
        prev = cur;
    }
    return min1;
}




