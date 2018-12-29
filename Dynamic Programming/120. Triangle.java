
/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

*/

/*

Solution 1: dp[i][j] means the minimum sum when we have t[i][j] element in this sum
            dp[i][j]=min(dp[i-1][j-1],dp[i-1][j])+t[i][j], which means choose the minimum sum in the previous row
            the final state is dp[n-1][i] for 0<=i<n, choose the minimum one
O(n^2),O(n^2)

*/

public int minimumTotal(List<List<Integer>> triangle) {
    int ans = Integer.MAX_VALUE, n = triangle.size();
    int[][] dp = new int[n][n];
    dp[0][0] = triangle.get(0).get(0);
    for (int i = 1; i < n; ++i) {
        for (int j = 0; j < triangle.get(i).size(); ++j) {
            if (j == 0) dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
            else if (j == triangle.get(i).size() - 1) dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
            else dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
        }
    }
    for (int i = 0; i < n; ++i) ans = Math.min(ans, dp[n - 1][i]);
    return ans;
}


/*

Solution 2: start from bottom to top, so the final state is dp[0], because the top element should be always in the sum
            dp[i] means the minimum sum with ith element in the current row
            dp[i]=min(dp[i],dp[i+1])+t[row][i], which means choose the minimum sum in the row below the current one
O(n^2),O(n)            

*/

public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] dp = new int[n + 1];
    for (int i = n - 1; i >= 0; --i) {
        for (int j = 0; j < triangle.get(i).size(); ++j)
            dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
    }
    return dp[0];
}




