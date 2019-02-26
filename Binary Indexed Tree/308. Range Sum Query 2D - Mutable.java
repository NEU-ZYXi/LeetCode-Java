
/*

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by 
its upper left corner (row1, col1) and lower right corner (row2, col2).

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10

*/

/*

O(nmlognlogm) build, O(lognlogm) update and query, O(nm)

*/

class NumMatrix {
    
    private int[][] mat;
    private int[][] BIT;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        int n = matrix.length, m = matrix[0].length;
        this.mat = new int[n][m];
        this.BIT = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) update(i, j, matrix[i][j]);
        }
    }
    
    private int lowbit(int i) {
        return i & (-i);
    }
    
    public void update(int row, int col, int val) {
        for (int i = row + 1; i <= mat.length; i += lowbit(i)) {
            for (int j = col + 1; j <= mat[0].length; j += lowbit(j)) BIT[i][j] += val - mat[row][col];
        }
        mat[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2 + 1, col2 + 1) - query(row2 + 1, col1) - query(row1, col2 + 1) + query(row1, col1);
    }
    
    private int query(int row, int col) {
        int ans = 0;
        for (int i = row; i > 0; i -= lowbit(i)) {
            for (int j = col; j > 0; j -= lowbit(j)) ans += BIT[i][j];
        }
        return ans;
    }
}




