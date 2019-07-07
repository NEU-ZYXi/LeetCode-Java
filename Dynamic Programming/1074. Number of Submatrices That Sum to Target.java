
/*

Given a matrix, and a target, return the number of non-empty submatrices that sum to target.
A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different 
if they have some coordinate that is different: for example, if x1 != x1'.

Example 1:
Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
Explanation: The four 1x1 submatrices that only contain 0.

Example 2:
Input: matrix = [[1,-1],[-1,1]], target = 0
Output: 5
Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.

*/

/*

Solution 1: for each (i,j) position, do DP for matrix sum and accumulate the one with sum equals to target
O(n^2m^2),O(nm)

*/

public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length, ans = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            int[][] dp = new int[n][m];
            for (int r = i; r < n; ++r) {
                for (int c = j; c < m; ++c) {
                    if (r == i && c == j) {
                        dp[r][c] = matrix[r][c];
                    } else if (r == i) {
                        dp[r][c] = dp[r][c - 1] + matrix[r][c];
                    } else if (c == j) {
                        dp[r][c] = dp[r - 1][c] + matrix[r][c];
                    } else {
                        dp[r][c] = dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1] + matrix[r][c];
                    }
                    if (dp[r][c] == target) {
                        ans++;
                    }
                }
            }
        }
    }
    return ans;
}


/*

Solution 2: calculate prefix sum of each row
            for each pair of columns, accumulate the sum of the current submatrix
            use a hashmap to count the submatrix between the two columns which has sum of target
O(nm^2),O(n)          

*/

public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length, ans = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 1; j < m; ++j) {
            matrix[i][j] += matrix[i][j - 1];
        }
    }
    for (int i = 0; i < m; ++i) {
        for (int j = i; j < m; ++j) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            for (int k = 0; k < n; ++k) {
                sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                ans += map.getOrDefault(sum - target, 0);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }
    return ans;
}





