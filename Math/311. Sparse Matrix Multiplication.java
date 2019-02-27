
/*

Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.

Example:
Input:
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]
B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]
Output:
     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

*/

/*

Solution 1: brute force multiplication
O(n^3),O(n^2)

*/

public int[][] multiply(int[][] A, int[][] B) {
    int n = A.length, m = B[0].length;
    int[][] ans = new int[n][m];
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            for (int k = 0; k < A[0].length; ++k) ans[i][j] += A[i][k] * B[k][j];
        }
    }
    return ans;
}


/*

Solution 2: since it's a sparse matrix, when A[i][k] is 0, we do not need to do the multiplication for B[k][j] column
O(n^3),O(n^2)

*/

public int[][] multiply(int[][] A, int[][] B) {
    int n = A.length, m = B[0].length;
    int[][] ans = new int[n][m];
    for (int i = 0; i < n; ++i) {
        for (int k = 0; k < A[0].length; ++k) {
            if (A[i][k] != 0) {
                for (int j = 0; j < m; ++j) ans[i][j] += A[i][k] * B[k][j];
            }
        }   
    }
    return ans;
}




