
/*

Given a matrix of M x N elements (M rows, N columns), 
return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]

*/

/*

O(nm),O(nm)

*/

public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix.length == 0) {
        return new int[0];
    }
    int n = matrix.length, m = matrix[0].length;
    int[] ans = new int[n * m];
    int row = 0, col = 0, delta = 1;
    for (int i = 0; i < n * m; ++i) {
        ans[i] = matrix[row][col];
        row -= delta;
        col += delta; 
        if (row >= n) {
            row = n - 1;
            delta = -delta;
            col += 2;
        } 
        if (col >= m) {
            col = m - 1;
            delta = -delta;
            row += 2;
        }
        if (row < 0) {
            row = 0;
            delta = -delta;
        }
        if (col < 0) {
            col = 0;
            delta = -delta;
        } 
    }
    return ans;
}




