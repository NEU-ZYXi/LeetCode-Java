
/*

We have a two dimensional matrix A where each value is 0 or 1.
A move consists of choosing any row or column, and toggling each value in that row or column: 
changing all 0s to 1s, and all 1s to 0s.
After making any number of moves, every row of this matrix is interpreted as a binary number, 
and the score of the matrix is the sum of these numbers.
Return the highest possible score.

Example 1:
Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

*/

/*

Solution: if the first column is '0', greedily flip this row
          if the column has more '0' than '1', greedily flip this column
O(nm),O(1)          

*/

public int matrixScore(int[][] A) {
    int n = A.length, m = A[0].length, ans = 0;
    for (int i = 0; i < n; ++i) {
        if (A[i][0] == 0) {
            flipRow(A, i);
        }
    }
    for (int j = 1; j < m; ++j) {
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += A[i][j];
        }
        if (cnt * 2 < n) {
            flipCol(A, j);
        }
    }
    for (int i = 0; i < n; ++i) {
        int cur = 0;
        for (int j = 0; j < m; ++j) {
            cur = (cur << 1) + A[i][j];
        }
        ans += cur;
    }
    return ans;
}

private void flipRow(int[][] A, int i) {
    for (int j = 0; j < A[0].length; ++j) {
        A[i][j] = (A[i][j] ^ 1);
    }
}

private void flipCol(int[][] A, int j) {
    for (int i = 0; i < A.length; ++i) {
        A[i][j] = (A[i][j] ^ 1);
    }
}



